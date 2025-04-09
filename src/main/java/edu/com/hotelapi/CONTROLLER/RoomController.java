package edu.com.hotelapi.CONTROLLER;


import edu.com.hotelapi.DTO.Room.RoomeRequestDTO;
import edu.com.hotelapi.DTO.Room.RoomeResponseDTO;
import edu.com.hotelapi.DTO.RoomResponseDTO;
import edu.com.hotelapi.Page.PageResponseDTO;
import edu.com.hotelapi.Response.ResponseDTO;
import edu.com.hotelapi.SERVICE.IRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {
    //
    private final IRoomService roomService;

    @GetMapping
    public ResponseEntity<PageResponseDTO<RoomeResponseDTO>> listar(
            @RequestParam (defaultValue = "0") Integer page,
            @RequestParam (defaultValue = "3") Integer size
    ){
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.status(200).body(roomService.getAllRooms(pageable));
    }


    @GetMapping("/{id}")
    public ResponseEntity<RoomeResponseDTO> buscarPorId(@PathVariable("id") Long id){
        return ResponseEntity.status(200).body(roomService.getRoom(id));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> crear(@RequestBody RoomeRequestDTO roomRequestDTO){
        return ResponseEntity.status(201).body(roomService.createRoom(roomRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> modificar(@RequestBody RoomeRequestDTO roomRequestDTO, @PathVariable("id") Long id){
        return ResponseEntity.status(200).body(roomService.updateRoom(id, roomRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> eliminar(@PathVariable("id") Long id){
        return ResponseEntity.status(200).body(roomService.deleteRoom(id));
    }
}


