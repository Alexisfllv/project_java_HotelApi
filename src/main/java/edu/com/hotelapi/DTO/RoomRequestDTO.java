package edu.com.hotelapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequestDTO {
    private Integer room_type;
    private BigDecimal room_price;
}
