package edu.com.hotelapi.MAPPER;

import edu.com.hotelapi.DTO.Room.RoomeRequestDTO;
import edu.com.hotelapi.DTO.Room.RoomeResponseDTO;
import edu.com.hotelapi.DTO.RoomResponseDTO;
import edu.com.hotelapi.ENTITY.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IRoomMapper {

    @Mapping(target = "id", source = "id")
    RoomResponseDTO toRoomResponseDTO(Room room);

    Room toRoom(RoomResponseDTO roomResponseDTO);


    // Req

    RoomeRequestDTO toRoomeRequestDTO(Room room);
    Room  toRoom( RoomeRequestDTO roomRequestDTO);

    //Res
    RoomeResponseDTO toRoomeResponseDTO(Room room);
    Room toRoom(RoomeResponseDTO roomResponseDTO);


}
