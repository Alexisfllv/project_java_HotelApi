package edu.com.hotelapi.Service;

import edu.com.hotelapi.DTO.Reservation.ReservationPlanoResponseDTO;
import edu.com.hotelapi.DTO.Reservation.ReservationRequestDTO;
import edu.com.hotelapi.DTO.Reservation.ReservationResponseDTO;

import java.util.List;

public interface ReservationService {
    // buscar
    ReservationPlanoResponseDTO buscar(Long id);
    // listar
    List<ReservationPlanoResponseDTO> listarReservas();
    // crear
    ReservationResponseDTO crearReserva(ReservationRequestDTO reservationRequestDTO);
}
