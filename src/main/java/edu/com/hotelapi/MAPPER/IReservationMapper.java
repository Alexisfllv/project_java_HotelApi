package edu.com.hotelapi.MAPPER;

import edu.com.hotelapi.DTO.ReservationRequestDTO;
import edu.com.hotelapi.DTO.ReservationResponseDTO;
import edu.com.hotelapi.ENTITY.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IReservationMapper {

    ReservationRequestDTO toReservationRequestDTO(Reservation reservation);

    @Mapping(target = "user.id" , source = "user_id")
    @Mapping(target = "room.id" , source = "room_id")
    Reservation toReservation(ReservationRequestDTO reservationRequestDTO);

    @Mapping(target = "user", source = "user")
    @Mapping(target = "room", source = "room")
    @Mapping(target = "room.precio_dto", source = "room.price")
    ReservationResponseDTO toReservationResponseDTO(Reservation reservation);
    Reservation toReservation(ReservationResponseDTO reservationResponseDTO);
}
