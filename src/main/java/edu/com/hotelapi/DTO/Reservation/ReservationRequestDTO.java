package edu.com.hotelapi.DTO.Reservation;

import edu.com.hotelapi.DTO.Historial.HistorialRequestDTO;
import edu.com.hotelapi.DTO.Total.TotalRequestDTO;

import java.time.LocalDateTime;
import java.util.List;

public record ReservationRequestDTO(
        LocalDateTime resv_start,
        LocalDateTime resv_end,
        String resv_status,
        String bill_name,
        String bill_email,
        String bill_telephone,
        // datos a ingresar
        Long userId,
        Long roomId,
        List<HistorialRequestDTO> historials,
        List<TotalRequestDTO> totals
) {}
