package edu.com.hotelapi.Service;

import edu.com.hotelapi.DTO.Usuario.UsuarioRequestDTO;
import edu.com.hotelapi.DTO.Usuario.UsuarioResponseDTO;

import java.util.List;

public interface UserService {

    List<UsuarioResponseDTO> listar();
    UsuarioResponseDTO buscar(Long id);
    UsuarioResponseDTO registrar(UsuarioRequestDTO usuario);
    UsuarioResponseDTO actualizar(UsuarioRequestDTO usuario,Long id);
    void eliminar(Long id);
}
