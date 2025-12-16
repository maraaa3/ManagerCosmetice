package com.proiect.ManagerCosmetice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 *Definește structura unui produs cosmetic
 * și mapează aceste câmpuri direct pe tabelul produse din baza de date.
 */

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataExpirare;

    private Double pret;

    private Integer stoc;
}