package edu.com.hotelapi.Controller;


import edu.com.hotelapi.DTO.Historial.HistorialFullResponseDTO;
import edu.com.hotelapi.Service.HistoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/historial")
@RequiredArgsConstructor
public class HistorialController {
    private final HistoriaService historialService;

    @GetMapping("/listar")
    public ResponseEntity<List<HistorialFullResponseDTO>> listarHistorial() {
        return ResponseEntity.ok(historialService.listarHistorial());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<HistorialFullResponseDTO> buscarHistorial(@PathVariable Long id) {
        return ResponseEntity.ok(historialService.buscarHistorial(id));
    }
}
