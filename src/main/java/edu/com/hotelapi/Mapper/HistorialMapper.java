package edu.com.hotelapi.Mapper;

import edu.com.hotelapi.DTO.Historial.HistorialResponseDTO;

import edu.com.hotelapi.ENTITY.ReservationHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring")
public interface HistorialMapper {

    // request


    @Mapping(target = "reservation_history_id", source = "reservation.id")
    HistorialResponseDTO toHistorialResponseDto(ReservationHistory reservationHistory);
}
