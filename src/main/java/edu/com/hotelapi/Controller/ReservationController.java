package edu.com.hotelapi.Controller;

import edu.com.hotelapi.DTO.Reservation.ReservationPlanoResponseDTO;
import edu.com.hotelapi.DTO.Reservation.ReservationRequestDTO;
import edu.com.hotelapi.DTO.Reservation.ReservationResponseDTO;
import edu.com.hotelapi.Service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ReservationPlanoResponseDTO> buscar(@PathVariable Long id) {
        return new ResponseEntity<>(reservationService.buscar(id), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ReservationPlanoResponseDTO>> listar() {
        return ResponseEntity.ok(reservationService.listarReservas());
    }

    @PostMapping("/registrar")
    public ResponseEntity<ReservationResponseDTO> registrar(@RequestBody ReservationRequestDTO reservationRequestDTO) {
        ReservationResponseDTO res = reservationService.crearReserva(reservationRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
}
