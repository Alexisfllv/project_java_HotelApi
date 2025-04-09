package edu.com.hotelapi.DTO.Room;

import java.math.BigDecimal;

public record RoomeRequestDTO(

        String type,
        BigDecimal precio

) {
}
