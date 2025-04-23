package edu.com.hotelapi.DTO.Historial;

import edu.com.hotelapi.ENTITY.Reservation;

import java.time.LocalDateTime;

public record HistorialFullResponseDTO(
        Long id,
        LocalDateTime history_date,
        String history_status,
        String history_notes,
        Reservation reservation
) {}
