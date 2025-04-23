package edu.com.hotelapi.DTO.Reservation;

import edu.com.hotelapi.DTO.Historial.HistorialResponseDTO;
import edu.com.hotelapi.DTO.Room.RoomResponseDTO;
import edu.com.hotelapi.DTO.Total.TotalResponseDTO;
import edu.com.hotelapi.DTO.Usuario.UsuarioResponseDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record ReservationPlanoResponseDTO(
        Long id,
        LocalDateTime resv_start,
        LocalDateTime resv_end,
        String resv_status,
        String bill_name,
        String bill_email,
        String bill_telephone,
        //usuario
        Long user_id,
        String user_name,
        String user_email,
        String user_tel,
        //room
        Long room_id,
        String room_type,
        BigDecimal room_price,
        //totals
        List<TotalPlanoDTO> totals,
        // historials
        List<HistorialPlanoDTO> historials

) {}
