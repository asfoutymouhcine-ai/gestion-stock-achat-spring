package com.example.gestion_stock_achat.web;

//import de l'entité Produit (table produit)
import com.example.gestion_stock_achat.entities.Produit;

//import du service (logique métier)
import com.example.gestion_stock_achat.service.ProduitService;

//annotations Spring pour créer API REST
import org.springframework.web.bind.annotation.*;

import java.util.List;

//indique que cette classe est un controller REST (API)
@RestController

//chemin de base pour les routes
@RequestMapping("/produits")
public class ProduitWeb {

    //appel au service pour accéder aux données
    private final ProduitService produitService;

    //constructeur (Spring injecte le service automatiquement)
    public ProduitWeb(ProduitService produitService) {
        this.produitService = produitService;
    }

    //récupérer tous les produits
    // GET http://localhost:8080/produits
    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    //ajouter un produit
    // POST http://localhost:8080/produits
    // body JSON contenant produit
    @PostMapping
    public Produit addProduit(@RequestBody Produit produit) {
        return produitService.saveProduit(produit);
    }

    //récupérer un produit par id
    // GET http://localhost:8080/produits/1
    @GetMapping("/{id}")
    public Produit getProduit(@PathVariable Long id) {
        return produitService.getProduitById(id)
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));
    }

    //supprimer un produit
    // DELETE http://localhost:8080/produits/1
    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
    }
    // modifier un produit
// PUT http://localhost:8080/produits/1
    @PutMapping("/{id}")
    public Produit updateProduit(@PathVariable Long id, @RequestBody Produit produit) {

        //chercher le produit existant
        Produit p = produitService.getProduitById(id)
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));

        // mise à jour des champs
        p.setNom(produit.getNom());
        p.setPrix(produit.getPrix());
        p.setQuantite(produit.getQuantite());

        //sauvegarder les modifications
        return produitService.saveProduit(p);
    }
}
