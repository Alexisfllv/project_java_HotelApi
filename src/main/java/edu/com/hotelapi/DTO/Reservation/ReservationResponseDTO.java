package edu.com.hotelapi.DTO.Reservation;

import edu.com.hotelapi.DTO.Historial.HistorialRequestDTO;
import edu.com.hotelapi.DTO.Historial.HistorialResponseDTO;
import edu.com.hotelapi.DTO.Room.RoomResponseDTO;
import edu.com.hotelapi.DTO.Total.TotalRequestDTO;
import edu.com.hotelapi.DTO.Total.TotalResponseDTO;
import edu.com.hotelapi.DTO.Usuario.UsuarioResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public record ReservationResponseDTO(
        Long id,
        LocalDateTime resv_start,
        LocalDateTime resv_end,
        String resv_status,
        String bill_name,
        String bill_email,
        String bill_telephone,
        // datos a ingresar
        UsuarioResponseDTO user,
        RoomResponseDTO room,
        List<HistorialResponseDTO> historials,
        List<TotalResponseDTO> totals
) {}
