package edu.com.hotelapi.Controller;


import edu.com.hotelapi.DTO.Total.TotalFullResponseDTO;
import edu.com.hotelapi.Service.TotalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/total")
@RequiredArgsConstructor
public class TotalController {

    private final TotalService totalService;

    @GetMapping("/listar")
    public ResponseEntity<List<TotalFullResponseDTO>> listarTotal() {
        return ResponseEntity.ok(totalService.listarTotal());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<TotalFullResponseDTO> buscarTotal(@PathVariable Long id) {
        return ResponseEntity.ok(totalService.buscarTotal(id));
    }
}
