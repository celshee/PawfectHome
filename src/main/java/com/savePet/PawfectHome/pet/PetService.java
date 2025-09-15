package com.savePet.PawfectHome.pet;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PetService {
    @Autowired
    private PetRepository repo;


    @Autowired
    private PetResponseDTOMapper mapper;

    @Autowired
    private PetRequestDTOMapper requestMapper;


    public PetResponseDTO getPetById(int id) {
        return mapper.toDto(repo.findById(id).orElse(null));
    }

    public PetResponseDTO addPet(PetRequestDTO request) {

        return  mapper.toDto(repo.save(new Pet(request.name,request.age,request.breed, request.gender, request.description, request.status, request.image_url,request.category,LocalDate.now())));
    }

    public void deletePet(int id) {
        repo.deleteById(id);
    }

    public PetResponseDTO updatePet(int id, @Valid PetRequestDTO request) {
        Pet pet = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found with id: " + id));

        pet.setName(request.getName());
        pet.setBreed(request.getBreed());
        pet.setAge(request.getAge());
        pet.setDescription(request.getDescription());
        pet.setImage_url(request.getImage_url());
        pet.setGender(request.getGender());
        pet.setStatus(request.getStatus());
        pet.setCategory(request.getCategory());

        Pet updatedPet = repo.save(pet);
        return mapper.toDto(updatedPet);
    }


    public List<PetResponseDTO> getAllPets() {
        return mapper.toDto(repo.findAll());
    }


    public List<PetResponseDTO> getPetsByBreed(String breed) {
        return mapper.toDto(repo.findByBreed(breed));
    }

}
