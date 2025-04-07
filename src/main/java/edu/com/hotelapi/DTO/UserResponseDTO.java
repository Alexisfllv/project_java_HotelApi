package edu.com.hotelapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private Long id;
    private String name;
//    private String email;
//    private String telephone;
    private String emailEmpresa;
    private String phoneEmpresa;
}
