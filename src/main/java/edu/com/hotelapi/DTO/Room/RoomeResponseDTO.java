package edu.com.hotelapi.DTO.Room;

import java.math.BigDecimal;

public record RoomeResponseDTO(

        Long id,
        String type,
        BigDecimal precio

) {
}
