package com.savePet.PawfectHome.pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("pet")
public class PetController {
    @Autowired
    private PetService service;
    @GetMapping("/pet/{id}")
    public ResponseEntity<Pet> getPet(@PathVariable int id){
        Pet pet = service.getPetById(id);
        if(pet!=null){
            return new ResponseEntity<>(service.getPetById(id), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
 
}
