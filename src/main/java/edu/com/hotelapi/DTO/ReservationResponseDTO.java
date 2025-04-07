package edu.com.hotelapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponseDTO {
    private LocalDateTime resv_start;
    private LocalDateTime resv_end;
    private String resv_status;
    private String user_name;
    private String user_email;
    private String user_phone;

    private String bill_name;
    private String bill_email;
    private String bill_telephone;

    // fks
    private UserResponseDTO userResponseDTO;
    private RoomResponseDTO romResponseDTO;
}
