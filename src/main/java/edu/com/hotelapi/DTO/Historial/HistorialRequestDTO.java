package edu.com.hotelapi.DTO.Historial;

import edu.com.hotelapi.ENTITY.Reservation;

import java.time.LocalDateTime;

public record HistorialRequestDTO(
        //LocalDateTime history_date,
        String history_status,
        String history_notes
        // Long reservationId
) {}
