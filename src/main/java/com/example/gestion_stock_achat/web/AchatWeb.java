package com.example.gestion_stock_achat.web;

import com.example.gestion_stock_achat.entities.Achat;
import com.example.gestion_stock_achat.service.AchatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/achats")
public class AchatWeb {

    private final AchatService achatService;

    public AchatWeb(AchatService achatService) {
        this.achatService = achatService;
    }

    //GET all achats
    @GetMapping
    public List<Achat> getAllAchats() {
        return achatService.getAllAchats();
    }

    //POST ajouter achat
    @PostMapping
    public Achat ajouterAchat(@RequestParam Long produitId,
                              @RequestParam Long fournisseurId,
                              @RequestParam int quantite) {
        return achatService.ajouterAchat(produitId, fournisseurId, quantite);
    }

    //DELETE achat
    @DeleteMapping("/{id}")
    public void deleteAchat(@PathVariable Long id) {
        achatService.deleteAchat(id);
    }
}
