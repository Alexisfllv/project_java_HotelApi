package edu.com.hotelapi.SERVICE;

import edu.com.hotelapi.DTO.ReservationRequestDTO;
import edu.com.hotelapi.DTO.ReservationResponseDTO;
import edu.com.hotelapi.ENTITY.Reservation;

public interface IReservationService {

    // registro de la Reservacion
    ReservationResponseDTO registrar(ReservationRequestDTO reservationRequestDTO);


}
