package edu.com.hotelapi.Service.Impl;

import edu.com.hotelapi.DTO.Total.TotalFullResponseDTO;
import edu.com.hotelapi.ENTITY.ReservationTotal;
import edu.com.hotelapi.Exception.Errors.ExDataNotFoundException;
import edu.com.hotelapi.Mapper.TotalMapper;
import edu.com.hotelapi.REPOSITORY.ITotalRepo;
import edu.com.hotelapi.Service.TotalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TotalServiceImpl implements TotalService {

    private final TotalMapper totalMapper;
    private final ITotalRepo totalRepo;


    @Override
    public List<TotalFullResponseDTO> listarTotal() {
        List<ReservationTotal> totals = totalRepo.findAll();
        return totals.stream()
                .map(reservationTotal -> totalMapper.toTotalFullResponseDTO(reservationTotal))
                .toList();
    }

    @Override
    public TotalFullResponseDTO buscarTotal(Long id) {
        ReservationTotal total = totalRepo.findById(id)
                .orElseThrow(() -> new ExDataNotFoundException("Reservation Total no encontrado : "+id));
        return totalMapper.toTotalFullResponseDTO(total);
    }
}
