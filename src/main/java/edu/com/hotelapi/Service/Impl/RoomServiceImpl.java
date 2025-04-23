package edu.com.hotelapi.Service.Impl;


import edu.com.hotelapi.DTO.Room.RoomRequestDTO;
import edu.com.hotelapi.DTO.Room.RoomResponseDTO;
import edu.com.hotelapi.ENTITY.Room;
import edu.com.hotelapi.Exception.Errors.ExDataNotFoundException;
import edu.com.hotelapi.Mapper.RoomMapper;
import edu.com.hotelapi.REPOSITORY.IRoomRepo;
import edu.com.hotelapi.Service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomMapper roomMapper;
    private final IRoomRepo roomRepo;

    @Override
    public List<RoomResponseDTO> listar() {
        List<Room> rooms = roomRepo.findAll();
        return rooms.stream()
                .map(room -> roomMapper.toRoomResponseDTO(room))
                .toList();
    }

    @Override
    public RoomResponseDTO buscar(Long id) {
        Room model = roomRepo.findById(id).
                orElseThrow(() -> new ExDataNotFoundException("room no encontrado : " + id));
        return roomMapper.toRoomResponseDTO(model);
    }

    @Override
    public RoomResponseDTO registrar(RoomRequestDTO roomRequestDTO) {
        Room room = roomMapper.toRoom(roomRequestDTO);

        roomRepo.save(room);
        return roomMapper.toRoomResponseDTO(room);
    }

    @Override
    public RoomResponseDTO actualizar(RoomRequestDTO roomRequestDTO, Long id) {
        Room room = roomRepo.findById(id)
                .orElseThrow(() -> new ExDataNotFoundException("room no encontrado : " + id));
        room.setType(roomRequestDTO.type());
        room.setPrice(roomRequestDTO.price());

        roomRepo.save(room);
        return roomMapper.toRoomResponseDTO(room);
    }

    @Override
    public void eliminar(Long id) {
        Room room = roomRepo.findById(id)
                .orElseThrow(() -> new ExDataNotFoundException("room no encontrado : " + id));
        roomRepo.delete(room);
    }
}
