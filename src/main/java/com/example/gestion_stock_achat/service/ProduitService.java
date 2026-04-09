package com.example.gestion_stock_achat.service;

//import de l'entity Produit (table produit)
import com.example.gestion_stock_achat.entities.Produit;

//import du repository (pour communiquer avec la base de données)
import com.example.gestion_stock_achat.repository.ProduitRepository;

//annotation pour dire que cette classe est un service Spring
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Service = contient la logique métier
@Service
public class ProduitService {

    //repository pour accéder à la base de données
    private final ProduitRepository produitRepository;

    //constructeur (Spring injecte automatiquement le repository)
    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    //récupérer tous les produits
    public List<Produit> getAllProduits() {
        return produitRepository.findAll(); // JPA fait la requête automatiquement
    }

    //ajouter ou modifier un produit
    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    //récupérer un produit par son id
    public Optional<Produit> getProduitById(Long id) {
        return produitRepository.findById(id);
    }

    //supprimer un produit par son id
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
}
