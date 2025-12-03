package com.proiect.ManagerCosmetice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "utilizatori")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilizator;

    private String nume;

    @Column(unique = true, nullable = false)
    private String utilizator;

    @Column(nullable = false)
    private String parola;

    @Column(nullable = false)
    private String rol;

}