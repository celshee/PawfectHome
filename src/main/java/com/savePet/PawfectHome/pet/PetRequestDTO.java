package com.savePet.PawfectHome.pet;

import com.savePet.PawfectHome.petPosting.PetStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PetRequestDTO {
    String name;
    int age;
    String breed;
    Gender gender;
    String description;
    PetStatus status;
    String image_url;
    String category;
}
