package edu.com.hotelapi.Service;


import edu.com.hotelapi.DTO.Reservation.TotalPlanoDTO;
import edu.com.hotelapi.DTO.Total.TotalFullResponseDTO;

import java.util.List;

public interface TotalService {

    List<TotalFullResponseDTO> listarTotal();
    TotalFullResponseDTO buscarTotal(Long id);
}
