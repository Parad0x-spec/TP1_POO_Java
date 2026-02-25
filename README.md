# 🍷 Gestion de Stock - Cave à Vins et Spiritueux

## Description
Ce projet est une application Java permettant de gérer un inventaire de bouteilles. Il met en œuvre les principes de la **Programmation Orientée Objet (POO)**.

## Fonctionnalités
* Affichage complet du catalogue.
* Recherche par nom de domaine.
* Mise à jour dynamique des prix.
* Suppression de références.
* Ajout de nouveaux produits avec extension automatique du stock.

## Algorithme

1. Exercice 1

````mermaid
graph TD
    %% 1. Initialisation
    Start([Début]) --> A["Initialiser 'listeProduits' (vide)"]
    A --> B["Définir Classe 'Produit' (Nom + Prix)"]
    
    %% 2. Ajout des données
    B --> C["Ajouter instances de Produit à la liste"]
    
    %% 3. Boucle de parcours
    C --> Loop{Pour chaque produit p}
    Loop -- "Parcourir" --> Format["Préparer affichage : Nom -- Prix €"]
    Format --> Loop
    
    %% 4. Affichage final
    Loop -- "Fin de liste" --> Display[/Afficher la liste complète/]
    
    %% 5. Tri
    Display --> Choice{Choisir le tri}
    Choice -- "Par Nom" --> SortN["Trier par Nom (A-Z)"]
    Choice -- "Par Prix" --> SortP["Trier par Prix (Croissant)"]
    
    SortN --> Final[/Afficher résultat trié/]
    SortP --> Final
    
    Final --> End([Fin])

    %% Couleurs pour différencier les étapes
    style Loop fill:#f9f,stroke:#333
    style Choice fill:#b3e5fc,stroke:#01579b
```
2. Exercice 2

```mermaid
graph TD
    %% 1. Initialisation
    Start([Début]) --> A["Scanner : Lire 'termeRecherche'"]
    
    %% 2. Processus de Recherche
    A --> B["Appeler Recherche (termeRecherche)"]
    B --> Loop{Parcourir le catalogue}
    
    Loop -- "Comparer domaine" --> Match{Correspondance ?}
    Match -- "Non" --> Loop
    Match -- "Oui" --> Found["Stocker l'objet trouvé"]
    
    %% 3. Condition de résultat
    Loop -- "Fin de liste (non trouvé)" --> Error[/Afficher 'Produit introuvable'/]
    Found --> Display[/Afficher détails du produit trouvé/]
    
    %% 4. Interaction de modification
    Display --> Update["Scanner : Lire 'nouveauPrix'"]
    Update --> Apply["Appliquer nouveauPrix via Setter"]
    
    %% 5. Conclusion
    Apply --> Confirm[/Afficher confirmation + Javadoc/]
    Error --> Choice{Réessayer ?}
    Choice -- "Oui" --> A
    Choice -- "Non" --> End([Fin])
    Confirm --> End

    %% Couleurs
    style Match fill:#fff9c4,stroke:#fbc02d
    style Found fill:#c8e6c9,stroke:#2e7d32
    style Error fill:#ffcdd2,stroke:#c62828
```

3. Exercice 3

```mermaid
graph TD
    %% 1. Initialisation
    Start([Début]) --> A["Scanner : Lire 'domaineASupprimer'"]
    
    %% 2. Recherche de la cible
    A --> B["Appeler Recherche (domaineASupprimer)"]
    B --> Match{Produit trouvé ?}
    
    %% 3. Gestion de l'échec
    Match -- "Non" --> Error[/Afficher 'Erreur : Produit inexistant'/]
    Error --> End([Fin])
    
    %% 4. Processus de suppression
    Match -- "Oui" --> Loop{Parcourir le catalogue}
    Loop -- "Trouver l'index de l'objet" --> Nullify["Assigner 'null' à cet index"]
    
    %% 5. Conclusion
    Nullify --> Confirm[/Afficher 'Produit supprimé avec succès'/]
    Confirm --> End

    %% Couleurs
    style Match fill:#fff9c4,stroke:#fbc02d
    style Nullify fill:#ffcdd2,stroke:#c62828
    style Confirm fill:#c8e6c9,stroke:#2e7d32
```

4. Exercice 4

```mermaid
graph TD
    %% 1. Initialisation
    Start([Début]) --> Input["Scanner : Saisir les infos du Produit (Type, Nom, Prix...)"]
    
    %% 2. Vérification de la capacité
    Input --> Capacity{Reste-t-il une place 'null' ?}
    
    %% 3. Extension si nécessaire
    Capacity -- "Non (Plein)" --> Resize["Appeler 'agrandirStock'"]
    Resize --> NewArray["Créer tableau plus grand + Copier anciens produits"]
    NewArray --> Add
    
    %% 4. Insertion
    Capacity -- "Oui (Libre)" --> Add["Chercher le premier index 'null'"]
    Add --> Insert["Placer le 'nouveauProduit' à cet index"]
    
    %% 5. Conclusion
    Insert --> Success[/Afficher 'Produit ajouté au catalogue'/]
    Success --> End([Fin])

    %% Couleurs
    style Capacity fill:#fff9c4,stroke:#fbc02d
    style Resize fill:#bbdefb,stroke:#1976d2
    style Insert fill:#c8e6c9,stroke:#2e7d32
```

5. Ajout pour le TP2

```mermaid
graph TD
    Start([Début]) --> Input["Scanner : Saisir les infos du Produit"]
    Input --> Capacity{Reste-t-il une place 'null' ?}
    Capacity -- "Non (Plein)" --> Resize["Appeler 'agrandirStock'"]
    Resize --> NewArray["Créer tableau plus grand + Copier anciens produits"]
    NewArray --> Add
    Capacity -- "Oui (Libre)" --> Add["Chercher le premier index 'null'"]
    Add --> Insert["Placer le 'nouveauProduit' à cet index"]
    Insert --> Success[/Afficher 'Produit ajouté au catalogue'/]
    Success --> End([Fin])
```
6. Architecture global

```mermaid
graph LR
    subgraph "Vue (Affichage)"
        V[CatalogueVue]
    end

    subgraph "Controleur (Logique)"
        C[CatalogueControleur]
    end

    subgraph "Modele (Données)"
        M[Produit / Vin / Spiritueux]
        ML[MentionLegal]
    end

    Main(Main.java) --> C
    C --> M
    C --> V
    M --- ML
```
## Documentation Technique (Javadoc)
La documentation détaillée des classes et méthodes a été générée.
Pour la consulter :
1. Allez dans le dossier `Doc_TP1_Java`.
2. Ouvrez le fichier `index.html` avec votre navigateur.

## Installation et Lancement
1. Importez le projet dans IntelliJ IDEA.
2. Assurez-vous d'utiliser le **JDK 21** ou plus récent.
3. Exécutez la classe `Main.java`.

## Crédit
L'élaboration de ce projet a été fait par :
    Boyer Clément

Durant ce projet Une IA ma aidé pour la correction, 
L'apprentissage et pour la documentation "Doxygène"
IA : gemini
