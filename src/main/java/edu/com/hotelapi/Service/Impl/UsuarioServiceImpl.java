package edu.com.hotelapi.Service.Impl;


import edu.com.hotelapi.DTO.Usuario.UsuarioRequestDTO;
import edu.com.hotelapi.DTO.Usuario.UsuarioResponseDTO;
import edu.com.hotelapi.ENTITY.User;
import edu.com.hotelapi.Exception.Errors.ExDataNotFoundException;
import edu.com.hotelapi.Mapper.UsuarioMapper;
import edu.com.hotelapi.REPOSITORY.IUserRepo;
import edu.com.hotelapi.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl  implements UserService {

    private final UsuarioMapper usuarioMapper;
    private final IUserRepo userRepo;

    @Override
    public List<UsuarioResponseDTO> listar() {
        List<User> usuarios = userRepo.findAll();
        return usuarios.stream()
                .map(user -> usuarioMapper.toUsuarioResponseDTO(user))
                .toList();
    }

    @Override
    public UsuarioResponseDTO buscar(Long id) {
        User user = userRepo.findById(id).
                orElseThrow(() -> new ExDataNotFoundException("usuario no encontrado : " + id));
        return usuarioMapper.toUsuarioResponseDTO(user);
    }

    @Override
    public UsuarioResponseDTO registrar(UsuarioRequestDTO usuario) {
        User user = usuarioMapper.toUser(usuario);

        userRepo.save(user);
        return usuarioMapper.toUsuarioResponseDTO(user);
    }

    @Override
    public UsuarioResponseDTO actualizar(UsuarioRequestDTO usuario, Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new ExDataNotFoundException("usuario no encontrado : " + id));
        user.setName(usuario.name());
        user.setEmail(usuario.email());
        user.setPassword(usuario.password());
        user.setRole(usuario.role());
        user.setTelephone(usuario.telephone());
        userRepo.save(user);
        return usuarioMapper.toUsuarioResponseDTO(user);
    }

    @Override
    public void eliminar(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new ExDataNotFoundException("usuario no encontrado : " + id));
        userRepo.delete(user);
    }
}
