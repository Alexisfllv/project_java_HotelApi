package edu.com.hotelapi.Controller;

import edu.com.hotelapi.DTO.Room.RoomRequestDTO;
import edu.com.hotelapi.DTO.Room.RoomResponseDTO;
import edu.com.hotelapi.DTO.Usuario.UsuarioRequestDTO;
import edu.com.hotelapi.DTO.Usuario.UsuarioResponseDTO;
import edu.com.hotelapi.Service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping("/listar")
    public ResponseEntity<List<RoomResponseDTO>> listar() {
        return ResponseEntity.ok(roomService.listar());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<RoomResponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(roomService.buscar(id));
    }

    @PostMapping("/registrar")
    public ResponseEntity<RoomResponseDTO> registrar(@RequestBody RoomRequestDTO roomRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(roomService.registrar(roomRequestDTO));
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<RoomResponseDTO> modificar(@RequestBody RoomRequestDTO roomRequestDTO,@PathVariable Long id) {
        return ResponseEntity.ok(roomService.actualizar(roomRequestDTO,id));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<RoomResponseDTO> eliminar(@PathVariable Long id) {
        roomService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
