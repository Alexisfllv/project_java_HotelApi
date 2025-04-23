package edu.com.hotelapi.DTO.Reservation;

import java.time.LocalDateTime;

public record HistorialPlanoDTO(
        Long id,
        LocalDateTime history_date,
        String history_status,
        String history_notes,
        Long reservation_history_id
) { }
