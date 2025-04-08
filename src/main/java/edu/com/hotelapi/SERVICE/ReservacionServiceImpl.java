package edu.com.hotelapi.SERVICE;

import edu.com.hotelapi.DTO.ReservationRequestDTO;
import edu.com.hotelapi.DTO.ReservationResponseDTO;
import edu.com.hotelapi.DTO.RoomResponseDTO;
import edu.com.hotelapi.DTO.UserResponseDTO;
import edu.com.hotelapi.ENTITY.*;
import edu.com.hotelapi.MAPPER.IReservationMapper;
import edu.com.hotelapi.MAPPER.IRoomMapper;
import edu.com.hotelapi.MAPPER.IUserMapper;
import edu.com.hotelapi.REPOSITORY.*;
import edu.com.hotelapi.UTILL.UtillReservationServiceImpl.ReservationCalculationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservacionServiceImpl implements IReservationService {

    private final IUserRepo userRepo;
    private final IHistoryRepo historyRepo;
    private final ITotalRepo totalRepo;
    private final IReservationRepo reservationRepo;
    private final IRoomRepo roomRepo;

    private final IReservationMapper reservationMapper;
    private final IRoomMapper roomMapper;
    private final IUserMapper userMapper;

    // utill
    private final ReservationCalculationService calculationService;

    @Override
    public List<ReservationResponseDTO> listar() {
        List<Reservation> reservations = reservationRepo.findAll();

         return reservations.stream()
                .map(reservation -> {
                    ReservationResponseDTO dto = reservationMapper.toReservationResponseDTO(reservation);

                    dto.setTotal_days("Días de estancia: " + calculationService.calcularDias(dto.getResv_start(), dto.getResv_end()));
                    
                    // calcular total
                    BigDecimal precio = calculationService.calcularPrecio(dto.getRoom().getId());

                    BigDecimal total = precio.multiply(BigDecimal.valueOf(calcularDias(dto.getResv_start(), dto.getResv_end())));

                    dto.setTotal_price("Valor total: " + total);

                    UserResponseDTO userDto = userMapper.toUserResponseDTO(reservation.getUser());
                    userDto.setEmailEmpresa("ListadoEmailEmpresa@Gmail.com");
                    userDto.setPhoneEmpresa("111111");
                    dto.setUser(userDto);

                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public ReservationResponseDTO registrar(ReservationRequestDTO reservationRequestDTO) {

        //mappear el dto a modelo
        Reservation reservation = reservationMapper.toReservation(reservationRequestDTO);

        reservation.setResv_start(reservationRequestDTO.getResv_start());
        reservation.setResv_end(reservationRequestDTO.getResv_end());
        reservation.setResv_status(reservationRequestDTO.getResv_status());
        reservation.setUser_name(reservationRequestDTO.getUser_name());
        reservation.setUser_email(reservationRequestDTO.getUser_email());
        reservation.setUser_telephone(reservationRequestDTO.getUser_telephone());
        reservation.setBill_name(reservationRequestDTO.getBill_name());
        reservation.setBill_email(reservationRequestDTO.getBill_email());
        reservation.setBill_telephone(reservationRequestDTO.getBill_telephone());

        // validacion de user_id
        User user = userRepo.findById(reservationRequestDTO.getUser_id())
                .orElseThrow(() -> new RuntimeException("No se encontro el usuario id: "+reservationRequestDTO.getUser_id()));
        reservation.setUser(user);

        // validacion de room_id
        Room room = roomRepo.findById(reservationRequestDTO.getRoom_id())
                .orElseThrow(()-> new RuntimeException("No se encontro el room id: "+reservationRequestDTO.getRoom_id()));
        reservation.setRoom(room);

        reservation = reservationRepo.save(reservation);

        ReservationResponseDTO respuesta = reservationMapper.toReservationResponseDTO(reservation);
        UserResponseDTO respuestaUsuario = userMapper.toUserResponseDTO(user);


        // llenar campos de Reservacion Historia
        ReservationHistory reservationHistory = new ReservationHistory();
        reservationHistory.setHistory_date(LocalDateTime.now());
        reservationHistory.setHistory_status(reservationRequestDTO.getResv_status());
        reservationHistory.setHistory_notes("Creacion de reservacion: "+reservationRequestDTO.getResv_start() + " hasta :" + reservationRequestDTO.getResv_end());
        reservationHistory.setReservation(reservation);
        historyRepo.save(reservationHistory);

        // llenar campos de Reservacion Total
        ReservationTotal reservationTotal = new ReservationTotal();
        reservationTotal.setTotal_title("--- Total ---");

        // proceso para hallar el costo
        Long userId =  reservation.getRoom().getId();
        BigDecimal totalAmount = switch (userId.intValue()){
            case 1 -> BigDecimal.valueOf(100);
            case 2 -> BigDecimal.valueOf(200);
            case 3 -> BigDecimal.valueOf(300);
            default -> BigDecimal.ZERO;
        };

        log.warn("RESERVATION/ROOM/ID = {}", reservation.getRoom().getId());

        // proceso de diferencia de dias
        long daysBetween = ChronoUnit.DAYS.between(
                reservationRequestDTO.getResv_start().toLocalDate(),
                reservationRequestDTO.getResv_end().toLocalDate()
        );
        int durationInDays = (int) daysBetween;
        // multiplicacion :
        BigDecimal total = totalAmount.multiply(BigDecimal.valueOf(durationInDays));

        reservationTotal.setTotal_amount(total);
        //
        reservationTotal.setReservation(reservation);
        totalRepo.save(reservationTotal);

        // finish

        // formar respuesta =
        respuesta.setTotal_days("Días de estancia: " + durationInDays);
        respuesta.setTotal_price("Total a pagar : " + total);

        // sobre escritura campo user
        respuestaUsuario.setEmailEmpresa("empresa@gmail.com");
        respuestaUsuario.setPhoneEmpresa("empresaphone@gmail.com");

        respuesta.setUser(respuestaUsuario);

        return respuesta;

    }

    // metodo



    private int calcularDias(LocalDateTime startDate, LocalDateTime endDate) {
        // proceso de diferencia de dias
        long daysBetween = ChronoUnit.DAYS.between(
                startDate.toLocalDate(), endDate.toLocalDate()
        );
        return (int) daysBetween;
    }

    private BigDecimal calcularPrecio(Long id){

        BigDecimal totalAmount = switch (id.intValue()){
            case 1 -> BigDecimal.valueOf(100);
            case 2 -> BigDecimal.valueOf(200);
            case 3 -> BigDecimal.valueOf(300);
            default -> BigDecimal.ZERO;

        };
        return totalAmount;
    }
}
