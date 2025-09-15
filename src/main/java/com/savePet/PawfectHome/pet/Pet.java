package com.savePet.PawfectHome.pet;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.savePet.PawfectHome.adoption.AdoptionRequest;
import com.savePet.PawfectHome.petPosting.PetPosting;
import com.savePet.PawfectHome.petPosting.PetStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private int age;

    private String breed;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String description;

    @Enumerated(EnumType.STRING)
    private PetStatus status = PetStatus.AVAILABLE;


    private String image_url;

    private String category;

    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate created_at;


    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PetPosting> postings = new HashSet<>();

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AdoptionRequest> adoptionRequests = new HashSet<>();


    public Pet(String name, int age, String breed, Gender gender, String description, PetStatus status, String imageUrl, String category, LocalDate createdAt) {
        this.name=name;
        this.age=age;
        this.breed=breed;
        this.gender=gender;
        this.description=description;
        this.status=status;
        this.image_url=imageUrl;
        this.category=category;
        this.created_at = createdAt;
    }
}
