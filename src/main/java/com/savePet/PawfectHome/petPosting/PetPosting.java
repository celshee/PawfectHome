package com.savePet.PawfectHome.petPosting;

import com.savePet.PawfectHome.user.User;
import com.savePet.PawfectHome.pet.Pet;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "pet_postings")
public class PetPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
