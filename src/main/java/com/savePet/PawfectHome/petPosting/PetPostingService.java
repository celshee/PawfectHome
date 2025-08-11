package com.savePet.PawfectHome.petPosting;

import com.savePet.PawfectHome.pet.Pet;
import com.savePet.PawfectHome.pet.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PetPostingService {
    @Autowired
    private PetPostingRepository repo;
    private PetRepository petrepo;
    private Pet pet;
    public List<PetPosting> getAllPets() {
        return repo.findAll();
    }

    public Pet addPetPosting(Pet pet) {
        return petrepo.save(pet);
    }

}
