package edu.com.hotelapi.SERVICE.Impl;


import edu.com.hotelapi.DTO.UserRequestDTO;
import edu.com.hotelapi.DTO.UserResponseDTO;
import edu.com.hotelapi.DTO.Usuario.UsuarioRequestDTO;
import edu.com.hotelapi.DTO.Usuario.UsuarioResponseDTO;
import edu.com.hotelapi.ENTITY.User;
import edu.com.hotelapi.MAPPER.IUserMapper;
import edu.com.hotelapi.Page.PageResponseDTO;
import edu.com.hotelapi.REPOSITORY.IUserRepo;
import edu.com.hotelapi.Response.ResponseDTO;
import edu.com.hotelapi.Response.ResponseMessage;
import edu.com.hotelapi.SERVICE.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    // ioc
    private final IUserRepo userRepo;

    @Qualifier("IUserMapperImpl")
    private final IUserMapper iUserMapper;


    @Override
    public PageResponseDTO<UsuarioResponseDTO> getAllUsers(Pageable pageable) {

        Page<UsuarioResponseDTO> paged = userRepo.findAll(pageable)
                .map(user -> iUserMapper.toUsuarioResponseDTO(user));

        return new PageResponseDTO<>(paged);
    }

    @Override
    public UsuarioResponseDTO getUser(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("NOT FOUND ID : "+id));

        return iUserMapper.toUsuarioResponseDTO(user);
    }

    @Override
    public ResponseDTO createUser(UsuarioRequestDTO usuarioRequestDTO) {
        User user = iUserMapper.toUser(usuarioRequestDTO);

        user.setName(usuarioRequestDTO.name());
        user.setEmail(usuarioRequestDTO.email());
        user.setTelephone(usuarioRequestDTO.telephone());
        user.setPassword(usuarioRequestDTO.password());
        user.setRole(usuarioRequestDTO.role());

        userRepo.save(user);
        UsuarioResponseDTO dto =  iUserMapper.toUsuarioResponseDTO(user);
        return new ResponseDTO(ResponseMessage.SUCCESSFUL_ADDITION.getMessage(),dto);
    }

    @Override
    public ResponseDTO updateUser(Long id, UsuarioRequestDTO usuarioRequestDTO) {
        User userexiste =  userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("NOT FOUND ID : "+id));

        userexiste.setName(usuarioRequestDTO.name());
        userexiste.setEmail(usuarioRequestDTO.email());
        userexiste.setTelephone(usuarioRequestDTO.telephone());
        userexiste.setPassword(usuarioRequestDTO.password());
        userexiste.setRole(usuarioRequestDTO.role());

        userRepo.save(userexiste);

        UsuarioResponseDTO dto =  iUserMapper.toUsuarioResponseDTO(userexiste);
        return new ResponseDTO(ResponseMessage.SUCCESSFUL_MODIFICATION.getMessage(),dto);
    }

    @Override
    public ResponseDTO deleteUser(Long id) {

        User userexiste =  userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("NOT FOUND ID : "+id));

        userRepo.delete(userexiste);

        return new ResponseDTO(ResponseMessage.SUCCESSFUL_DELETION.getMessage(),"delete id :"+id);

    }


}
