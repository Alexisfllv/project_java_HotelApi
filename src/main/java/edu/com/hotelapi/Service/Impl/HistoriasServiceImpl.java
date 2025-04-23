package edu.com.hotelapi.Service.Impl;

import edu.com.hotelapi.DTO.Historial.HistorialFullResponseDTO;
import edu.com.hotelapi.ENTITY.ReservationHistory;
import edu.com.hotelapi.Mapper.HistorialMapper;
import edu.com.hotelapi.REPOSITORY.IHistoryRepo;
import edu.com.hotelapi.Service.HistoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoriasServiceImpl implements HistoriaService {

    private final IHistoryRepo historyRepo;
    private final HistorialMapper historialMapper;

    @Override
    public List<HistorialFullResponseDTO> listarHistorial() {
        List<ReservationHistory> reservationHistories = historyRepo.findAll();
        return reservationHistories.stream()
                .map(reservationHistory -> historialMapper.toHistorialFullResponseDto(reservationHistory))
                .toList();
    }

    @Override
    public HistorialFullResponseDTO buscarHistorial(Long id) {
        ReservationHistory reservationHistory = historyRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Historial no encontrado : "+id));
        return historialMapper.toHistorialFullResponseDto(reservationHistory);
    }
}
