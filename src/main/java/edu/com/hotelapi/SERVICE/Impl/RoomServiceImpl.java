package edu.com.hotelapi.SERVICE.Impl;

import edu.com.hotelapi.DTO.Room.RoomeRequestDTO;
import edu.com.hotelapi.DTO.Room.RoomeResponseDTO;
import edu.com.hotelapi.DTO.RoomRequestDTO;
import edu.com.hotelapi.DTO.RoomResponseDTO;
import edu.com.hotelapi.ENTITY.Room;
import edu.com.hotelapi.Exception.Errors.ExDataNotFoundException;
import edu.com.hotelapi.MAPPER.IRoomMapper;
import edu.com.hotelapi.Page.PageResponseDTO;
import edu.com.hotelapi.REPOSITORY.IRoomRepo;
import edu.com.hotelapi.Response.ResponseDTO;
import edu.com.hotelapi.Response.ResponseMessage;
import edu.com.hotelapi.SERVICE.IRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements IRoomService {


    @Qualifier("IRoomMapper")
    private final IRoomMapper roomMapper;

    private final IRoomRepo roomRepo;

    @Override
    public PageResponseDTO<RoomeResponseDTO> getAllRooms(Pageable pageable) {
        Page<RoomeResponseDTO> paged = roomRepo.findAll(pageable)
                .map(room -> roomMapper.toRoomeResponseDTO(room));

        return new PageResponseDTO<>(paged);

    }

    @Override
    public RoomeResponseDTO getRoom(Long id) {
        Room room = roomRepo.findById(id)
                .orElseThrow(()-> new ExDataNotFoundException("Room not found : "+id));

        return roomMapper.toRoomeResponseDTO(room);
    }

    @Override
    public ResponseDTO createRoom(RoomeRequestDTO roomRequestDTO) {
        Room room = roomMapper.toRoome(roomRequestDTO);

        room.setType(roomRequestDTO.type());
        room.setPrice(roomRequestDTO.price());

        roomRepo.save(room);
        RoomeResponseDTO dto = roomMapper.toRoomeResponseDTO(room);
        return new ResponseDTO(ResponseMessage.SUCCESSFUL_ADDITION.getMessage(), dto);
    }

    @Override
    public ResponseDTO updateRoom(Long id, RoomeRequestDTO roomRequestDTO) {
        Room roomExiste = roomRepo.findById(id)
                .orElseThrow(()-> new ExDataNotFoundException("Room not found : "+id));

        roomExiste.setType(roomRequestDTO.type());
        roomExiste.setPrice(roomRequestDTO.price());

        roomRepo.save(roomExiste);

        RoomeResponseDTO dto = roomMapper.toRoomeResponseDTO(roomExiste);
        return new ResponseDTO(ResponseMessage.SUCCESSFUL_MODIFICATION.getMessage(), dto);

        }

    @Override
    public ResponseDTO deleteRoom(Long id) {
        Room roomExiste = roomRepo.findById(id)
                .orElseThrow(()-> new ExDataNotFoundException("Room not found : "+id));

        roomRepo.delete(roomExiste);
        return new ResponseDTO(ResponseMessage.SUCCESSFUL_DELETION.getMessage(), null);
    }
}



