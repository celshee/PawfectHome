package com.savePet.PawfectHome.pet;

import com.savePet.PawfectHome.petPosting.PetStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;


public class PetService {
    @Autowired
    private PetRepository repo;

    public Pet getPetById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Pet addPet(String name, int age, String breed, Gender gender, String description, PetStatus status, String image_url, String category, LocalDate created_at) {
        return repo.save(new Pet(name,age, breed, gender, description, status, image_url,category,created_at));
    }
}
