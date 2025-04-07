package edu.com.hotelapi.MAPPER;

import edu.com.hotelapi.DTO.ReservationRequestDTO;
import edu.com.hotelapi.ENTITY.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IReservationMapper {

    ReservationRequestDTO toReservationRequestDTO(Reservation reservation);

    @Mapping(target = "user.id" , source = "user_id")
    @Mapping(target = "room.id" , source = "room_id")
    Reservation toReservation(ReservationRequestDTO reservationRequestDTO);
    
}
