package com.example.gestion_stock_achat.web;

import com.example.gestion_stock_achat.entities.Fournisseur;
import com.example.gestion_stock_achat.service.FournisseurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseurs")
public class FournisseurWeb {

    private final FournisseurService fournisseurService;

    public FournisseurWeb(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    //GET all fournisseurs
    @GetMapping
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurService.getAllFournisseurs();
    }

    // POST ajouter fournisseur
    @PostMapping
    public Fournisseur addFournisseur(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.saveFournisseur(fournisseur);
    }

    //GET fournisseur by id
    @GetMapping("/{id}")
    public Fournisseur getFournisseur(@PathVariable Long id) {
        return fournisseurService.getFournisseurById(id)
                .orElseThrow(() -> new RuntimeException("Fournisseur introuvable"));
    }

    // UPDATE fournisseur
    @PutMapping("/{id}")
    public Fournisseur updateFournisseur(@PathVariable Long id, @RequestBody Fournisseur fournisseur) {

        Fournisseur f = fournisseurService.getFournisseurById(id)
                .orElseThrow(() -> new RuntimeException("Fournisseur introuvable"));

        f.setNom(fournisseur.getNom());
        f.setContact(fournisseur.getContact());

        return fournisseurService.saveFournisseur(f);
    }

    // DELETE fournisseur
    @DeleteMapping("/{id}")
    public void deleteFournisseur(@PathVariable Long id) {
        fournisseurService.deleteFournisseur(id);
    }
}
