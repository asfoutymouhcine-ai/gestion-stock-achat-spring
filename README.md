# Gestion Stock Achat - Spring Boot

## Description
Application de gestion des stocks et des achats développée avec Spring Boot.  
Ce projet permet de gérer les produits, les fournisseurs et les achats avec une logique métier automatique de mise à jour du stock.

---

## Architecture
Le projet suit une architecture en couches :

- **web** → Controllers (API REST)
- **service** → Logique métier
- **repository** → Accès à la base de données
- **entities** → Modèles (tables)

---

## Technologies utilisées

- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- REST API
- Lombok

---

## Entités

### Produit
- id
- nom
- prix
- quantite

###  Fournisseur
- id
- nom
- contact

### Achat
- id
- produit
- fournisseur
- quantite
- date

---

## Fonctionnalités

✔️ CRUD Produit  
✔️ CRUD Fournisseur  
✔️ Gestion des achats  
✔️ Mise à jour automatique du stock  

---

## Logique métier

Lors de l’ajout d’un achat :

> La quantité du produit est automatiquement augmentée.

Exemple :
- Stock = 10
- Achat = 5  
  Nouveau stock = 15

---

##  API Endpoints

###  Produits
- GET `/produits`
- POST `/produits`
- GET `/produits/{id}`
- PUT `/produits/{id}`
- DELETE `/produits/{id}`

---

### Fournisseurs
- GET `/fournisseurs`
- POST `/fournisseurs`
- GET `/fournisseurs/{id}`
- PUT `/fournisseurs/{id}`
- DELETE `/fournisseurs/{id}`

---

### Achats
- GET `/achats`
- POST `/achats?produitId=1&fournisseurId=1&quantite=5`
- DELETE `/achats/{id}`

---

## Test avec Postman

### Ajouter produit
```json
{
  "nom": "Clavier",
  "prix": 100,
  "quantite": 10
}
