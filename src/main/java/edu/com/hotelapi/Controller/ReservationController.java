package edu.com.hotelapi.Controller;

import edu.com.hotelapi.DTO.Reservation.ReservationRequestDTO;
import edu.com.hotelapi.DTO.Reservation.ReservationResponseDTO;
import edu.com.hotelapi.Service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reserva")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping("/registrar")
    public ResponseEntity<ReservationResponseDTO> registrar(@RequestBody ReservationRequestDTO reservationRequestDTO) {
        ReservationResponseDTO res = reservationService.crearReserva(reservationRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
}
