package edu.com.hotelapi.Controller;

import edu.com.hotelapi.DTO.Usuario.UsuarioRequestDTO;
import edu.com.hotelapi.DTO.Usuario.UsuarioResponseDTO;
import edu.com.hotelapi.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.listar());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.buscar(id));
    }

    @PostMapping("/registrar")
    public ResponseEntity<UsuarioResponseDTO> registrar(@RequestBody  UsuarioRequestDTO usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registrar(usuario));
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<UsuarioResponseDTO> modificar(@RequestBody UsuarioRequestDTO usuario,@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.actualizar(usuario,id));
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<UsuarioResponseDTO> eliminar(@PathVariable Long id) {
        userService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
