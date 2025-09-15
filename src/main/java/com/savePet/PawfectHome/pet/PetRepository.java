package com.savePet.PawfectHome.pet;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet,Integer>{
    List<Pet> findByBreed(String breed);
}
