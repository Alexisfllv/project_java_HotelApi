package edu.com.hotelapi.SERVICE;

import edu.com.hotelapi.DTO.ReservationRequestDTO;
import edu.com.hotelapi.DTO.ReservationResponseDTO;
import edu.com.hotelapi.ENTITY.Reservation;

import java.util.List;

public interface IReservationService {


    // listar
    List<ReservationResponseDTO> listar();

    // registro de la Reservacion
    ReservationResponseDTO registrar(ReservationRequestDTO reservationRequestDTO);


}
