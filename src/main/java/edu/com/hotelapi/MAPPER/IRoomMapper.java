package edu.com.hotelapi.MAPPER;

import edu.com.hotelapi.DTO.RoomResponseDTO;
import edu.com.hotelapi.ENTITY.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IRoomMapper {

    @Mapping(target = "id", source = "id")
    RoomResponseDTO toRoomResponseDTO(Room room);

    Room toRoom(RoomResponseDTO roomResponseDTO);
}
