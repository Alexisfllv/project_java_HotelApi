package edu.com.hotelapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponseDTO {
    private Long id;
    private LocalDateTime resv_start;
    private LocalDateTime resv_end;
    private String resv_status;
    private String user_name;
    private String user_email;
    private String user_telephone;

    private String bill_name;
    private String bill_email;
    private String bill_telephone;

    //adicionales
    private String total_days;
    private String total_price;


    // fks
    private UserResponseDTO user;
    private RoomResponseDTO room;

}
