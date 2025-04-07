package edu.com.hotelapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequestDTO {

    private LocalDateTime resv_start;
    private LocalDateTime resv_end;
    private String resv_status;
    private String user_name;
    private String user_email;
    private String user_telephone;

    private String bill_name;
    private String bill_email;
    private String bill_telephone;

    // fks
    private Long user_id;
    private Long room_id;
}
