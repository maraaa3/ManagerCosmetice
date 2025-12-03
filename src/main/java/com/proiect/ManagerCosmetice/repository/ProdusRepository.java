package com.proiect.ManagerCosmetice.repository;

import com.proiect.ManagerCosmetice.entity.Produs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdusRepository extends JpaRepository<Produs, Long> {

    @Query("SELECT p FROM Produs p WHERE " +
            "(:brand IS NULL OR p.brand LIKE :brand%) AND " +
            "(:categorie IS NULL OR p.categorie LIKE :categorie%) AND " +
            "(:tip IS NULL OR p.tipProdus LIKE :tip%)")
    List<Produs> filtreazaProduse(@Param("brand") String brand,
                                  @Param("categorie") String categorie,
                                  @Param("tip") String tip);
}