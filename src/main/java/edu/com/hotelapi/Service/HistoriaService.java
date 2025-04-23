package edu.com.hotelapi.Service;

import edu.com.hotelapi.DTO.Historial.HistorialFullResponseDTO;

import java.util.List;

public interface HistoriaService {
    List<HistorialFullResponseDTO> listarHistorial();

    HistorialFullResponseDTO buscarHistorial(Long id);
}
