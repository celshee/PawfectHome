package com.savePet.PawfectHome.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.savePet.PawfectHome.adoption.AdoptionRequest;
import com.savePet.PawfectHome.petPosting.PetPosting;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email ;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private String phoneNo;


    @Enumerated(EnumType.STRING)
    private Role role ;


    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PetPosting> petPostings = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AdoptionRequest> adoptionRequests = new HashSet<>();

}
