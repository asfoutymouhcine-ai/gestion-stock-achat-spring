package com.example.gestion_stock_achat.repository;

import com.example.gestion_stock_achat.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
