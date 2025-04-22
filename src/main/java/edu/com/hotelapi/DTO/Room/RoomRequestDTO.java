package edu.com.hotelapi.DTO.Room;

import java.math.BigDecimal;

public record RoomRequestDTO(
        String type,
        BigDecimal price
) {}
