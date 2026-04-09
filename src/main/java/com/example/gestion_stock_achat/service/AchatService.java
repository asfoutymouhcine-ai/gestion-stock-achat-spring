package com.example.gestion_stock_achat.service;

//import des entities (tables)
import com.example.gestion_stock_achat.entities.Achat;
import com.example.gestion_stock_achat.entities.Fournisseur;
import com.example.gestion_stock_achat.entities.Produit;

//import des repositories (accès à la base de données)
import com.example.gestion_stock_achat.repository.AchatRepository;
import com.example.gestion_stock_achat.repository.FournisseurRepository;
import com.example.gestion_stock_achat.repository.ProduitRepository;

//annotation pour dire que c'est un service Spring
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

// Service = contient la logique métier
@Service
public class AchatService {

    //repositories pour communiquer avec la base de données
    private final AchatRepository achatRepository;
    private final ProduitRepository produitRepository;
    private final FournisseurRepository fournisseurRepository;

    //constructeur (Spring injecte automatiquement les repositories)
    public AchatService(AchatRepository achatRepository,
                        ProduitRepository produitRepository,
                        FournisseurRepository fournisseurRepository) {
        this.achatRepository = achatRepository;
        this.produitRepository = produitRepository;
        this.fournisseurRepository = fournisseurRepository;
    }

    // récupérer tous les achats
    public List<Achat> getAllAchats() {
        return achatRepository.findAll(); // JPA fait la requête automatiquement
    }

    //ajouter un achat
    public Achat ajouterAchat(Long produitId, Long fournisseurId, int quantite) {

        //chercher le produit dans la base de données
        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));

        // chercher le fournisseur dans la base de données
        Fournisseur fournisseur = fournisseurRepository.findById(fournisseurId)
                .orElseThrow(() -> new RuntimeException("Fournisseur introuvable"));

        // créer un nouvel objet Achat
        Achat achat = new Achat();

        // lier l'achat avec le produit
        achat.setProduit(produit);

        // lier l'achat avec le fournisseur
        achat.setFournisseur(fournisseur);

        // définir la quantité achetée
        achat.setQuantite(quantite);

        // définir la date actuelle
        achat.setDate(LocalDate.now());

        // LOGIQUE MÉTIER IMPORTANTE :
        // augmenter la quantité du produit en stock
        // exemple : stock = 10, achat = 5 → stock devient 15
        produit.setQuantite(produit.getQuantite() + quantite);

        // sauvegarder le produit mis à jour
        produitRepository.save(produit);

        // sauvegarder l'achat dans la base de données
        return achatRepository.save(achat);
    }

    // supprimer un achat par id
    public void deleteAchat(Long id) {
        achatRepository.deleteById(id);
    }
}
