package edu.com.hotelapi.DTO.Usuario;

public record UsuarioRequestDTO(
        String name,
        String email,
        String telephone,
        String password,
        String role

) {
}
