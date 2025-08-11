package com.savePet.PawfectHome.adoption;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.savePet.PawfectHome.pet.Pet;
import com.savePet.PawfectHome.user.User;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;


@Entity
@Data
@Table(name = "AdoptionRequests")
public class AdoptionRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private User user_id;
    @ManyToOne
    private Pet pet_id;
   @Enumerated(EnumType.STRING)
    private AdoptionStatus status;
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate adoption_date;
}
