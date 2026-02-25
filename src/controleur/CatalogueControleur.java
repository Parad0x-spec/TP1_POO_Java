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
        Produit[] stock = new Produit[50];

        // Les Vin
        stock[0] = new Vin("Vin", "Château Margaux", "Premier Grand Cru", 450.00f,
                new MentionLegal(13.5f, "Contient des sulfites - Mis en bouteille au château"), "Rouge", 2);
        stock[1] = new Vin("Vin", "Domaine de la Palme", "Cuvée de table", 8.50f,
                new MentionLegal(12.0f, "Vin de France - Mis en bouteille à la propriété"), "Rouge", 150);
        stock[2] = new Vin("Vin", "Mouton Cadet", "Baron Philippe", 12.90f,
                new MentionLegal(13.0f, "AOC Bordeaux - Élevé en fûts de chêne"), "Rouge", 45);
        stock[3] = new Vin("Vin", "Veuve Clicquot", "Carte Jaune", 45.00f,
                new MentionLegal(12.5f, "Champagne - Appellation d'Origine Contrôlée"), "Blanc", 24);
        stock[4] = new Vin("Vin", "Château d'Yquem", "Sauternes", 320.00f,
                new MentionLegal(14.0f, "Contient des sulfites - Vin de garde"), "Blanc", 1);
        stock[5] = new Vin("Vin", "Miraval", "Côtes de Provence", 18.50f,
                new MentionLegal(13.0f, "AOP Côtes de Provence - Produit de France"), "Rosé", 60);
        stock[6] = new Vin("Vin", "Minuty", "Prestige", 16.00f,
                new MentionLegal(12.5f, "Cru Classé - Provence"), "Rosé", 80);
        stock[7] = new Vin("Vin", "Pétrus", "Pomerol 2018", 3200.00f,
                new MentionLegal(14.5f, "Grand Vin de Bordeaux - Rare"), "Rouge", 1);
        stock[8] = new Vin("Vin", "Cloudy Bay", "Sauvignon Blanc", 29.00f,
                new MentionLegal(13.5f, "Produit de Nouvelle-Zélande - Marlborough"), "Blanc", 12);
        stock[9] = new Vin("Vin", "Gevrey-Chambertin", "Pinot Noir", 55.00f,
                new MentionLegal(13.0f, "Bourgogne - Vieilles Vignes"), "Rouge", 8);

        // Les Spiritueux
        stock[10] = new Spiritueux("Spiritueux", "Ricard", "Pastis de Marseille", 19.90f,
                new MentionLegal(45.0f, "Anisé - Alcool de plantes"), 100);
        stock[11] = new Spiritueux("Spiritueux", "Jack Daniels", "Old No.7", 24.50f,
                new MentionLegal(40.0f, "Tennessee Whiskey - Filtré sur charbon"), 40);
        stock[12] = new Spiritueux("Spiritueux", "Hibiki", "Japanese Harmony", 95.00f,
                new MentionLegal(43.0f, "Blended Whisky - Produit du Japon"), 3);
        stock[13] = new Spiritueux("Spiritueux", "Grey Goose", "L'Original", 38.00f,
                new MentionLegal(40.0f, "Vodka de blé - Distillée en France"), 15);
        stock[14] = new Spiritueux("Spiritueux", "Hendrick's", "Small Batch", 34.00f,
                new MentionLegal(44.0f, "Gin infusé au concombre et à la rose"), 20);
        stock[15] = new Spiritueux("Spiritueux", "Diplomatico", "Reserva Exclusiva", 42.00f,
                new MentionLegal(40.0f, "Rhum de tradition espagnole - Venezuela"), 25);
        stock[16] = new Spiritueux("Spiritueux", "Hennessy", "V.S.O.P", 65.00f,
                new MentionLegal(40.0f, "Cognac - Appellation Cognac Contrôlée"), 5);
        stock[17] = new Spiritueux("Spiritueux", "Patron", "Silver", 48.00f,
                new MentionLegal(40.0f, "100% Agave - Tequila Premium"), 10);
        stock[18] = new Spiritueux("Spiritueux", "Baileys", "Original", 15.50f,
                new MentionLegal(17.0f, "Crème de whisky - Contient des produits laitiers"), 50);
        stock[19] = new Spiritueux("Spiritueux", "Macallan", "12 Years", 85.00f,
                new MentionLegal(40.0f, "Single Malt Scotch Whisky - Highland"), 4);

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
            if (p != null) {
                // On compare le domaine du produit actuel avec la recherche
                if (p.getDomaine().equalsIgnoreCase(domaineRecherche)) { // test .equalsIgnoreCase ne fonctionne pas et la normalisation
                    // n'est pas de mon niveau donc je ne l'ai pas ajouter
                    return p; // On a trouvé le produit, on stop la recherche ici
                }
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
        Produit[] nouveauStock = new Produit[stock.length + 10];

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

    /**
     * Vérifie si la quantité demandée est disponible et gère les alertes.
     * @param p Le produit sélectionné.
     * @param qteDemandee La quantité que le client veut acheter.
     * @return true si la vente est possible, false sinon.
     */
    public boolean verifierDisponibilite(Produit p, int qteDemandee) {
        if (p.getQuantiteStock() == 0) {
            System.out.println("ERREUR : Rupture de stock pour ce produit !");
            return false;
        }

        if (qteDemandee > p.getQuantiteStock()) {
            System.out.println("ERREUR : Stock insuffisant (Disponible : " + p.getQuantiteStock() + ")");
            return false;
        }

        // Alerte stock bas (seuil fixé à 3 bouteilles)
        if (p.getQuantiteStock() - qteDemandee <= 3) {
            System.out.println(" ALERTE : Le stock devient très bas après cette vente !");
        }

        return true;
    }
}