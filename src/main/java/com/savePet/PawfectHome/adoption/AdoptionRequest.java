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
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

   @Enumerated(EnumType.STRING)
   private AdoptionStatus status = AdoptionStatus.PENDING;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate adoption_date;
}
