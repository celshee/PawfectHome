package com.savePet.PawfectHome.pet;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService service;

        @PostMapping("/")
        public ResponseEntity<PetResponseDTO> addPet(@Valid @RequestBody PetRequestDTO request) {
            return ResponseEntity.ok(service.addPet(request));
        }

        @PutMapping("/{id}")
        public ResponseEntity<PetResponseDTO> updatePet(
                @PathVariable int id,
                @Valid @RequestBody PetRequestDTO request) {
            return ResponseEntity.ok(service.updatePet(id, request));
        }


        @DeleteMapping("/{id}")
        public void deletePet(@PathVariable int id) {
            service.deletePet(id);
        }


        @GetMapping("/{id}")
        public ResponseEntity<PetResponseDTO> getPetById(@PathVariable int id) {
            return ResponseEntity.ok(service.getPetById(id));
        }


        @GetMapping("/")
        public ResponseEntity<List<PetResponseDTO>> getAllPets() {
            return ResponseEntity.ok(service.getAllPets());
        }


        @GetMapping("/breed/{breed}")
        public ResponseEntity<List<PetResponseDTO>> getPetsByBreed(@PathVariable String breed) {
            return ResponseEntity.ok(service.getPetsByBreed(breed));
        }
}


