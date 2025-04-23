package edu.com.hotelapi.Service;

import edu.com.hotelapi.DTO.Room.RoomRequestDTO;
import edu.com.hotelapi.DTO.Room.RoomResponseDTO;

import java.util.List;

public interface RoomService {

    List<RoomResponseDTO> listar();
    RoomResponseDTO buscar(Long id);
    RoomResponseDTO registrar(RoomRequestDTO room);
    RoomResponseDTO actualizar(RoomRequestDTO room,Long id);
    void eliminar(Long id);
}

