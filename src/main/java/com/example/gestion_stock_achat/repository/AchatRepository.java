package com.example.gestion_stock_achat.repository;

import com.example.gestion_stock_achat.entities.Achat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchatRepository extends JpaRepository<Achat, Long> {
}
