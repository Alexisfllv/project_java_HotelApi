package edu.com.hotelapi.MAPPER;

import edu.com.hotelapi.DTO.UserResponseDTO;
import edu.com.hotelapi.DTO.Usuario.UsuarioRequestDTO;
import edu.com.hotelapi.DTO.Usuario.UsuarioResponseDTO;
import edu.com.hotelapi.ENTITY.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Qualifier;

@Mapper(componentModel = "spring")
public interface IUserMapper {


    // Response

    @Mapping(target = "id",source = "id")
    UserResponseDTO toUserResponseDTO(User user);

    User toUser(UserResponseDTO userResponseDTO);


    // Request

    UsuarioRequestDTO toUsuarioRequestDTO(User user);
    User toUser(UsuarioRequestDTO userRequestDTO);

    // Response

    UsuarioResponseDTO toUsuarioResponseDTO(User user);
    User toUser(UsuarioResponseDTO userResponseDTO);

}
