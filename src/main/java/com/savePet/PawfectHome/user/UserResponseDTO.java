package com.savePet.PawfectHome.user;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class UserResponseDTO {

    private int id;
    private String name;
    private String email;
    private String phoneNo;
    private String role;
    private String createdAt;

    public UserResponseDTO(int id, String name, String email, String phoneNo, String role, String createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.role = role;
        this.createdAt = createdAt;
    }

}
