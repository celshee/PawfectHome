package com.savePet.PawfectHome.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
public class UserRequestDTO {
    @NotBlank(message = "Username is required")
    private String name;
    @Email(message = "Invalid email")
    private String email ;
    @NotBlank(message = "Password is required")
    private String passwordHash;
    private String phoneNo;
}
