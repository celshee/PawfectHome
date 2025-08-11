package com.savePet.PawfectHome.petPosting;

import com.savePet.PawfectHome.user.User;
import com.savePet.PawfectHome.pet.Pet;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "pet_postings")
public class PetPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @ManyToOne
    private Pet pet_id;
    @ManyToOne
    private User user_id;
}
