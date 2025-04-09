package edu.com.hotelapi.DTO.Usuario;

public record UsuarioResponseDTO(
         Long id,
         String user_name,
         String user_email,
         String user_telephone,
         String user_password,
         String user_role
) {
}
