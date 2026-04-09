package com.example.gestion_stock_achat.repository;

import com.example.gestion_stock_achat.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository  extends JpaRepository<Fournisseur, Long> {
}
