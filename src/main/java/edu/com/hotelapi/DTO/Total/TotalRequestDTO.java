package edu.com.hotelapi.DTO.Total;

import java.math.BigDecimal;

public record TotalRequestDTO(
        String total_title,
        BigDecimal total_amount,
        Long reservationId
) {}
