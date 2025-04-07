package edu.com.hotelapi.CONTROLLER;


import edu.com.hotelapi.DTO.ReservationRequestDTO;
import edu.com.hotelapi.DTO.ReservationResponseDTO;
import edu.com.hotelapi.ENTITY.Reservation;
import edu.com.hotelapi.SERVICE.IReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservaciones")
@RequiredArgsConstructor
public class ReservationController {

    // ioc
    private final IReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationResponseDTO> createReservation(@RequestBody ReservationRequestDTO reservationRequestDTO) {
        return ResponseEntity.ok(reservationService.registrar(reservationRequestDTO));
    }


}
