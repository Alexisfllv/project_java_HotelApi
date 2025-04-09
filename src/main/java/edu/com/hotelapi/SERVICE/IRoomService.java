package edu.com.hotelapi.SERVICE;

import edu.com.hotelapi.DTO.Room.RoomeRequestDTO;
import edu.com.hotelapi.DTO.Room.RoomeResponseDTO;
import edu.com.hotelapi.DTO.RoomRequestDTO;
import edu.com.hotelapi.DTO.RoomResponseDTO;
import edu.com.hotelapi.Page.PageResponseDTO;
import edu.com.hotelapi.Response.ResponseDTO;
import org.springframework.data.domain.Pageable;

public interface IRoomService {

    //

    PageResponseDTO<RoomeResponseDTO> getAllRooms(Pageable pageable);

    RoomeResponseDTO getRoom(Long id);

    ResponseDTO createRoom(RoomeRequestDTO roomeRequestDTO);

    ResponseDTO updateRoom(Long id, RoomeRequestDTO roomeRequestDTO);

    ResponseDTO deleteRoom(Long id);
}
