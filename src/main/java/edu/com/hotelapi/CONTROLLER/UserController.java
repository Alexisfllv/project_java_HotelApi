package edu.com.hotelapi.CONTROLLER;


import edu.com.hotelapi.DTO.Usuario.UsuarioRequestDTO;
import edu.com.hotelapi.DTO.Usuario.UsuarioResponseDTO;
import edu.com.hotelapi.Page.PageResponseDTO;
import edu.com.hotelapi.Response.ResponseDTO;
import edu.com.hotelapi.SERVICE.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    // ioc
    private final IUserService userService;

    @GetMapping
    public ResponseEntity<PageResponseDTO<UsuarioResponseDTO>> getAllUsers(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "3") Integer size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.status(200).body(userService.getAllUsers(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> getUser(@PathVariable Long id) {
        return ResponseEntity.status(200).body(userService.getUser(id));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> createUser(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return ResponseEntity.status(201).body(userService.createUser(usuarioRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateUser(@PathVariable Long id, @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return ResponseEntity.status(200).body(userService.updateUser(id, usuarioRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable Long id) {
        return ResponseEntity.status(200).body(userService.deleteUser(id));
    }


}
