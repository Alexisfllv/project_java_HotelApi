package edu.com.hotelapi.SERVICE;


import edu.com.hotelapi.DTO.UserRequestDTO;
import edu.com.hotelapi.DTO.UserResponseDTO;
import edu.com.hotelapi.DTO.Usuario.UsuarioRequestDTO;
import edu.com.hotelapi.DTO.Usuario.UsuarioResponseDTO;
import edu.com.hotelapi.ENTITY.User;
import edu.com.hotelapi.Page.PageResponseDTO;
import edu.com.hotelapi.Response.ResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {

    // listar
    PageResponseDTO<UsuarioResponseDTO> getAllUsers(Pageable pageable);

    // buscar

    UsuarioResponseDTO getUser(Long id);
    // crear

    ResponseDTO createUser(UsuarioRequestDTO usuarioRequestDTO);
    // modificar

    ResponseDTO updateUser(Long id, UsuarioRequestDTO usuarioRequestDTO);

    // eliminar

    ResponseDTO deleteUser(Long id);
}
