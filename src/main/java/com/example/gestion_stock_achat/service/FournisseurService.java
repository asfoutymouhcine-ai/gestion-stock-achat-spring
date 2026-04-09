package com.example.gestion_stock_achat.service;

//import de l'entity Fournisseur (table fournisseur)
import com.example.gestion_stock_achat.entities.Fournisseur;

//import du repository (pour accéder à la base de données)
import com.example.gestion_stock_achat.repository.FournisseurRepository;

//annotation pour dire que cette classe est un service Spring
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Service = logique métier
@Service
public class FournisseurService {

    //repository pour communiquer avec la base de données
    private final FournisseurRepository fournisseurRepository;

    //constructeur (Spring injecte automatiquement le repository)
    public FournisseurService(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    //récupérer tous les fournisseurs
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurRepository.findAll(); // JPA fait la requête automatiquement
    }

    //ajouter ou modifier un fournisseur
    public Fournisseur saveFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    //récupérer un fournisseur par son id
    public Optional<Fournisseur> getFournisseurById(Long id) {
        return fournisseurRepository.findById(id);
    }

    //supprimer un fournisseur par son id
    public void deleteFournisseur(Long id) {
        fournisseurRepository.deleteById(id);
    }
}
