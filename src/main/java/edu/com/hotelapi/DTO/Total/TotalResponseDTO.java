package edu.com.hotelapi.DTO.Total;

import edu.com.hotelapi.ENTITY.Reservation;

import java.math.BigDecimal;

public record TotalResponseDTO(
        Long id,
        String total_title,
        BigDecimal total_amount,
        Long reservation_total_id
) {}
