package com.savePet.PawfectHome.pet;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.savePet.PawfectHome.petPosting.PetStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

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
    private int id;
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
    LocalDate myObj = LocalDate.now();
    public Pet(String name, int age, String breed, Gender gender, String description, PetStatus status, String imageUrl, String category, LocalDate createdAt) {
        this.name=name;
        this.age=age;
        this.breed=breed;
        this.gender=gender;
        this.description=description;
        this.status=status;
        this.image_url=imageUrl;
        this.category=category;
        this.created_at=myObj.now();
    }
}
