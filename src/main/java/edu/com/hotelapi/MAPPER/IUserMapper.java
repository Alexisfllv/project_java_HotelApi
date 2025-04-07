package edu.com.hotelapi.MAPPER;

import edu.com.hotelapi.DTO.UserResponseDTO;
import edu.com.hotelapi.ENTITY.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IUserMapper {

    @Mapping(target = "id",source = "id")
    UserResponseDTO toUserResponseDTO(User user);

    User toUser(UserResponseDTO userResponseDTO);


}
