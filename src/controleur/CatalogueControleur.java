package controleur;

import modele.*;

/**
 * Effectue une recherche textuelle dans le catalogue.
 * * @param stock Le tableau de produits à parcourir.
 * @param domaineRecherche Le nom du domaine (ex: "Château Margaux").
 * @return Le produit trouvé, ou null si aucune correspondance.
 */

/**
 * Test de polymorphisme, je crée un tableaude type (Produit) avec des sous type (Vin et Spiritueux)
 * Initialisation de du stock
 */

/**
 * Contrôleur gérant les opérations logiques sur le catalogue.
 */

public class CatalogueControleur {
    /**
     * Constructeur par défaut.
     */
    public CatalogueControleur() {}

    /**
     * Initialise le stock avec des données de test.
     * @return Un tableau de Produit rempli.
     */

    public Produit[] initialiserStock() { //C'est un tableau de produit qui prend les enfant en compte
        Produit[] stock = new Produit[3];

        // Les Spiritueux

        stock[0] = new Spiritueux("Cognac","Domaine des Remparts", "XO", 207.3f,
        new MentionLegal(40.0f, "Grande Champagne"));

        // Ajout d'un Vin
        stock[1] = new Vin("Vin", "Château Margaux", "Grand Cru", 450.0f,
                new MentionLegal(13.5f, "Notes de fruits rouges"), "Rouge");

        // Ajout d'un autre Spiritueux
        stock[2] = new Spiritueux("Armagnac", "Domaine de Laberdolive", "1995", 150.0f,
                new MentionLegal(42.0f, "Millésimé"));

        return stock;
    }

    /**
     * Recherche un produit dans le stock en fonction du nom du domaine.
     */

    /**
     * Recherche un produit spécifique par son nom de domaine.
     * @param stock Le tableau de produits dans lequel chercher.
     * @param domaineRecherche La chaîne de caractères à comparer.
     * @return Le produit trouvé, ou null si aucune correspondance.
     */

    public Produit rechercherParDomaine(Produit[] stock, String domaineRecherche) {
        if (stock == null)
            return null;

        for (Produit p : stock) {
            // On compare le domaine du produit actuel avec la recherche
            if (p.getDomaine().equalsIgnoreCase(domaineRecherche)) { // test .equalsIgnoreCase ne fonctionne pas et la normalisation
                // n'est pas de mon niveau donc je ne l'ai pas ajouter
                return p; // On a trouvé le produit, on stop la recherche ici
            }
        }
        return null; // Si on arrive ici, c'est qu'on n'a rien trouvé
        }

    /**
     * Modifie le prix d'un produit si il existe.
     */

    /**
     * Met à jour le prix d'un produit spécifique.
     * @param p Le produit à modifier.
     * @param nouveauPrix La nouvelle valeur monétaire.
     */

    public void mettreAJourPrix(Produit p, float nouveauPrix) {
        if (p != null && nouveauPrix > 0) {
            p.setPrix(nouveauPrix);
            System.out.println("Système : Le prix a été mis à jour avec succès.");
        }
    }

    /**
     * Test pour agrandir le stock
     */

    /**
     * Agrandit la taille du tableau de stockage.
     * @param stock Le tableau actuel à agrandir.
     * @return Un nouveau tableau plus grand contenant les anciens produits.
     */

    public Produit[] agrandirStock(Produit[] stock) {
        // Vérifie s'il reste au moins une place
        for (Produit p : stock) {
            if (p == null) return stock;
        }
        // Sinon, on double la taille
        Produit[] nouveauStock = new Produit[stock.length + 2];

        for (int i = 0; i < stock.length; i++){
            nouveauStock[i] = stock[i];
        }
        System.arraycopy(stock, 0, nouveauStock, 0, stock.length);
        return nouveauStock;
    }



    /**
     * Pour ajouter un produit on doit vérifier si la place dans le tableau n'est pas déjà prise
     */

    /**
     * Ajoute une référence au catalogue.
     * @param stock Le tableau de destination.
     * @param nouveau Le produit à ajouter.
     * @return true si l'ajout est réussi, false sinon.
     */

    public boolean ajouterProduit(Produit[] stock, Produit nouveau) {
        if (stock == null || nouveau == null) return false;

        for (int i = 0; i < stock.length; i++) {
            if (stock[i] == null) { // On a trouvé une place libre !
                stock[i] = nouveau;
                return true;
            }
        }
        return false; // Plus de place dans le tableau
    }

    /**
     * Supprime un produit du stock en mettant sa référence à null.
     */

    /**
     * Supprime un produit du stock.
     * @param stock Le tableau de produits actuel.
     * @param aSupprimer La référence de l'objet à retirer.
     */

    public void supprimerProduit(Produit[] stock, Produit aSupprimer) {
        if (stock == null || aSupprimer == null) return;

        for (int i = 0; i < stock.length; i++) {
            // On cherche l'objet précis dans le tableau
            if (stock[i] == aSupprimer) {
                stock[i] = null; // On vide la case
                System.out.println("Système : Produit retiré du stock.");
                return;
            }
        }
    }
}