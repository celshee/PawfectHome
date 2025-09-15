package com.savePet.PawfectHome.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDTO {
    @Email(message = "Invalid email")
    private String email ;
    @NotBlank(message = "Password is required")
    private String password;

}
