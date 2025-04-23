package edu.com.hotelapi.Service.Impl;


import edu.com.hotelapi.DTO.Reservation.ReservationPlanoResponseDTO;
import edu.com.hotelapi.DTO.Reservation.ReservationRequestDTO;
import edu.com.hotelapi.DTO.Reservation.ReservationResponseDTO;
import edu.com.hotelapi.ENTITY.*;
import edu.com.hotelapi.Mapper.*;
import edu.com.hotelapi.REPOSITORY.*;
import edu.com.hotelapi.Service.ReservationService;
import edu.com.hotelapi.UTILL.UtillReservationServiceImpl.ReservationCalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    // mapper
    private final ReservationMapper reservationMapper;

    // repos
    private final IReservationRepo reservationRepo;

    private final IRoomRepo roomRepo;
    private final IUserRepo userRepo;

    // metodos
    private final ReservationCalculationService reservationCalculationService;

    @Override
    public ReservationPlanoResponseDTO buscar(Long id) {
        Reservation reservation = reservationRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Reservation with id " + id + " not found"));
        return reservationMapper.toReservationPlanoResponseDto(reservation);
    }

    @Override
    public List<ReservationPlanoResponseDTO> listarReservas() {
        List<Reservation> reservations = reservationRepo.findAll();
        return reservations.stream()
                .map(reservation -> reservationMapper.toReservationPlanoResponseDto(reservation))
                .toList();
    }

    @Transactional
    @Override
    public ReservationResponseDTO crearReserva(ReservationRequestDTO reservationRequestDTO) {

        Reservation reservation = new Reservation();
        reservation.setResv_start(reservationRequestDTO.resv_start());
        reservation.setResv_end(reservationRequestDTO.resv_end());
        reservation.setResv_status(reservationRequestDTO.resv_status());
        reservation.setBill_name(reservationRequestDTO.bill_name());
        reservation.setBill_email(reservationRequestDTO.bill_email());
        reservation.setBill_telephone(reservationRequestDTO.bill_telephone());

        // user id
        User usuarioExiste = userRepo.findById(reservationRequestDTO.userId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado :"+reservationRequestDTO.userId()));
        reservation.setUser(usuarioExiste);

        Room roomExiste = roomRepo.findById(reservationRequestDTO.roomId())
                .orElseThrow(() -> new RuntimeException("Room no encontrado :"+reservationRequestDTO.roomId()));
        reservation.setRoom(roomExiste);


        // create automatico historials
        List<ReservationHistory> histories = reservationRequestDTO.historials().stream()
                .map(dto -> {
                    ReservationHistory h = new ReservationHistory();
                    h.setHistory_date(LocalDateTime.now());
                    h.setHistory_status(dto.history_status());
                    h.setHistory_notes(dto.history_notes());
                    h.setReservation(reservation); // muy importante para la relación con Reservation
                    return h;
                })
                .toList();
        reservation.setHistorials(histories);

        // create automatico totals
        List<ReservationTotal> totals = reservationRequestDTO.totals().stream()
                .map(dto ->{
                    ReservationTotal t = new ReservationTotal();
                    t.setTotal_title("Costo Total");

                    // calcular totalamount
                    BigDecimal precioRoom = roomExiste.getPrice();

                    Integer cantDias = reservationCalculationService.calcularDias(reservation.getResv_start(), reservation.getResv_end());
                    BigDecimal totalAmount = precioRoom.multiply(BigDecimal.valueOf(cantDias));
                    t.setTotal_amount(totalAmount);
                    t.setReservation(reservation);
                    return t;
                })
                .toList();
        reservation.setTotals(totals);

        reservationRepo.save(reservation);
        return reservationMapper.toReservationResponseDto(reservation);
    }
}
