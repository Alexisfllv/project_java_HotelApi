package edu.com.hotelapi.DTO.Room;

import java.math.BigDecimal;

public record RoomResponseDTO(
        Long id,
        String type,
        BigDecimal price
) {}
