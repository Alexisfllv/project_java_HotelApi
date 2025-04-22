package edu.com.hotelapi.Mapper;


import edu.com.hotelapi.DTO.Usuario.UsuarioRequestDTO;
import edu.com.hotelapi.DTO.Usuario.UsuarioResponseDTO;
import edu.com.hotelapi.ENTITY.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {


    User toUser (UsuarioRequestDTO usuarioRequestDTO);

    UsuarioResponseDTO toUsuarioResponseDTO (User user);

}
