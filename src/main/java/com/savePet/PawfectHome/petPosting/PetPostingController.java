package com.savePet.PawfectHome.petPosting;

import com.savePet.PawfectHome.pet.Gender;
import com.savePet.PawfectHome.pet.Pet;
import com.savePet.PawfectHome.pet.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/posts")
public class PetPostingController {
    @Autowired
    private PetPostingService service;
    @Autowired
    private PetService petService;
    @GetMapping("/pet")
    public List<PetPosting> getAllPets(){
        return service.getAllPets();
    }


    }

