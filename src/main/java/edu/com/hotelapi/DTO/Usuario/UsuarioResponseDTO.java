package edu.com.hotelapi.DTO.Usuario;

public record UsuarioResponseDTO(
         Long id,
         String name,
         String email,
         String telephone,
         String password,
         String role
) {
}
