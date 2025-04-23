package edu.com.hotelapi.Mapper;

import edu.com.hotelapi.DTO.Historial.HistorialFullResponseDTO;
import edu.com.hotelapi.DTO.Historial.HistorialResponseDTO;

import edu.com.hotelapi.DTO.Reservation.HistorialPlanoDTO;
import edu.com.hotelapi.ENTITY.ReservationHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring")
public interface HistorialMapper {

    // Modelo full para reserva
    @Mapping(target = "reservation_history_id", source = "reservation.id")
    HistorialResponseDTO toHistorialResponseDto(ReservationHistory reservationHistory);

    // Modelo plano para reserva
    @Mapping(target = "reservation_history_id", source = "reservation.id")
    HistorialPlanoDTO toHistorialPlanoDto(ReservationHistory reservationHistory);

    // Modelo Full para Historial
    HistorialFullResponseDTO toHistorialFullResponseDto(ReservationHistory reservationHistory);

}
