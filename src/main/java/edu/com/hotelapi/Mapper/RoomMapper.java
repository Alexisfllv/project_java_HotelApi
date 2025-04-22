package edu.com.hotelapi.Mapper;

import edu.com.hotelapi.DTO.Room.RoomRequestDTO;
import edu.com.hotelapi.DTO.Room.RoomResponseDTO;
import edu.com.hotelapi.ENTITY.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    Room toRoom (RoomRequestDTO roomRequestDTO);
    RoomResponseDTO toRoomResponseDTO (Room room);
}
