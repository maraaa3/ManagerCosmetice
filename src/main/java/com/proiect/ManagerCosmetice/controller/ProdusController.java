package com.proiect.ManagerCosmetice.controller;

import com.proiect.ManagerCosmetice.entity.Produs;
import com.proiect.ManagerCosmetice.service.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProdusController {

    @Autowired
    private ProdusService produsService;

    //http://localhost:8080/produse
    @GetMapping("/produse")
    public String arataProdusele(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String categorie,
            @RequestParam(required = false) String tip,
            Model model) {

        List<Produs> listaProduse = produsService.filtreazaProduse(brand, categorie, tip);

        model.addAttribute("listaProduse", listaProduse);

        model.addAttribute("brandSelectat", brand);
        model.addAttribute("categorieSelectata", categorie);
        model.addAttribute("tipSelectat", tip);

        return "produse";
    }

    @GetMapping("/produse/nou")
    public String formularAdaugare(Model model) {
        Produs produsNou = new Produs();
        model.addAttribute("produs", produsNou);
        return "formular_produs";
    }

    @PostMapping("/produse/salveaza")
    public String salveazaProdus(@ModelAttribute("produs") Produs produs) {
        produsService.salveazaProdus(produs);
        return "redirect:/produse";
    }

    @GetMapping("/produse/editeaza/{id}")
    public String formularEditare(@PathVariable Long id, Model model) {
        Produs produsExistent = produsService.gasesteDupaId(id);
        model.addAttribute("produs", produsExistent);
        return "formular_produs";
    }

    @GetMapping("/produse/sterge/{id}")
    public String stergeProdus(@PathVariable Long id) {
        produsService.stergeProdus(id);
        return "redirect:/produse";
    }
}