package edu.com.hotelapi.DTO.Reservation;

import java.math.BigDecimal;

public record TotalPlanoDTO(
        Long id,
        String total_title,
        BigDecimal total_amount,
        Long reservation_total_id
) {}
