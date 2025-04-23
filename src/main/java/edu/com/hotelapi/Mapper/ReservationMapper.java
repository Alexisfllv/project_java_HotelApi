package edu.com.hotelapi.Mapper;

import edu.com.hotelapi.DTO.Reservation.ReservationPlanoResponseDTO;
import edu.com.hotelapi.DTO.Reservation.ReservationRequestDTO;
import edu.com.hotelapi.DTO.Reservation.ReservationResponseDTO;
import edu.com.hotelapi.ENTITY.Reservation;
import edu.com.hotelapi.ENTITY.ReservationHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring" , uses = {TotalMapper.class, HistorialMapper.class})
public interface ReservationMapper {

    Reservation toReservationDto(ReservationRequestDTO reservationRequestDTO);

    ReservationResponseDTO toReservationResponseDto(Reservation reservation);

    @Mapping(target = "user_id", source = "user.id")
    @Mapping(target = "user_name", source = "user.name")
    @Mapping(target = "user_email", source = "user.email")
    @Mapping(target = "user_tel", source = "user.telephone")
    @Mapping(target = "room_id", source = "room.id")
    @Mapping(target = "room_type", source = "room.type")
    @Mapping(target = "room_price", source = "room.price")
    ReservationPlanoResponseDTO toReservationPlanoResponseDto(Reservation reservation);
}
