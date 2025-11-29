package com.proiect.ManagerCosmetice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "produse")
@Data
@NoArgsConstructor
public class Produs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numeProdus;

    @Column(nullable = false)
    private String brand;

    private String categorie;

    private String tipProdus;

    private LocalDate dataExpirare;

    private Double pret;

    private Integer stoc;
}