package edu.com.hotelapi.Service;

import edu.com.hotelapi.DTO.Reservation.ReservationRequestDTO;
import edu.com.hotelapi.DTO.Reservation.ReservationResponseDTO;

import java.util.List;

public interface ReservationService {
    //
    ReservationResponseDTO buscarReservation(Long id);

    // listar
    List<ReservationResponseDTO> listarReservas();

    // crear
    ReservationResponseDTO crearReserva(ReservationRequestDTO reservationRequestDTO);
}
