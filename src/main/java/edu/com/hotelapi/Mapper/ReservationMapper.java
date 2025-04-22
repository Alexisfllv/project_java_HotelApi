package edu.com.hotelapi.Mapper;

import edu.com.hotelapi.DTO.Reservation.ReservationRequestDTO;
import edu.com.hotelapi.DTO.Reservation.ReservationResponseDTO;
import edu.com.hotelapi.ENTITY.Reservation;
import edu.com.hotelapi.ENTITY.ReservationHistory;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring" , uses = {TotalMapper.class, HistorialMapper.class})
public interface ReservationMapper {

    Reservation toReservationDto(ReservationRequestDTO reservationRequestDTO);

    ReservationResponseDTO toReservationResponseDto(Reservation reservation);
}
