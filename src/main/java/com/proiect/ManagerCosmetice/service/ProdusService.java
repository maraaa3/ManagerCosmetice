package com.proiect.ManagerCosmetice.service;

import com.proiect.ManagerCosmetice.entity.Produs;
import com.proiect.ManagerCosmetice.repository.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdusService {

    @Autowired
    private ProdusRepository produsRepository;

    public List<Produs> gasesteToateProdusele() {
        return produsRepository.findAll();
    }

    public List<Produs> filtreazaProduse(String brand, String categorie, String tip) {
        if (brand != null && brand.isEmpty()) brand = null;
        if (categorie != null && categorie.isEmpty()) categorie = null;
        if (tip != null && tip.isEmpty()) tip = null;

        return produsRepository.filtreazaProduse(brand, categorie, tip);
    }

    public void salveazaProdus(Produs produs) {
        produsRepository.save(produs);
    }

    public void stergeProdus(Long id) {
        produsRepository.deleteById(id);
    }

    public Produs gasesteDupaId(Long id) {
        return produsRepository.findById(id).orElse(null);
    }
}