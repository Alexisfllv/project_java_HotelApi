package edu.com.hotelapi.DTO.Total;

import edu.com.hotelapi.ENTITY.Reservation;

import java.math.BigDecimal;

public record TotalFullResponseDTO(
        Long id,
        String total_title,
        BigDecimal total_amount,
        Reservation reservation
) {}
