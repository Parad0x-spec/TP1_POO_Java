package vue;

import modele.Produit;
import modele.Vin;
import modele.Spiritueux;

/**
 * Gère l'affichage des données du catalogue sur la console.
 */

public class CatalogueVue {

    /** Constructeur par défaut. */
    public CatalogueVue() {}

    /**
     * Affiche la liste complète des produits du catalogue.
     * @param catalogue Le tableau de produits à afficher.
     */

    public void afficherCatalogue(Produit[] catalogue) {
        System.out.println("\n========================================================");
        System.out.println("                ETAT DU STOCK - CATALOGUE");
        System.out.println("========================================================");

        if (catalogue == null || catalogue.length == 0) {
            System.out.println("Information : Aucun produit en stock.");
            return;
        }

        for (Produit p : catalogue) {
            // CONDITION DE SÉCURITÉ : On ignoresi il a des cases vides
            if (p == null) {
                continue;
            }// Passe directement au produit suivant sans rien afficher
                // Détermination de la catégorie
                String categorie = (p instanceof Vin) ? "VIN" : "SPIRITUEUX";

                System.out.println("CATEGORIE: " + categorie);
                System.out.println("TYPE     : " + p.getType());
                System.out.println("DOMAINE  : " + p.getDomaine());
                System.out.println("PRODUIT  : " + p.getNom()); // Correction ici

                if (p instanceof Vin) {
                    System.out.println("COULEUR  : " + ((Vin) p).getCouleur());
                }

                // Accès aux mentions
                System.out.printf("ALCOOL   : %.1f%% vol %n", p.getMentions().getDegreAlcool());
                System.out.println("NOTE     : " + p.getMentions().getDescription());

                System.out.printf("PRIX     : %.1f EUR %n", p.getPrix());
                System.out.println("========================================================");
            }
        }

    /**
     * Affiche le résultat d'une recherche.
     */

    /**
     * Affiche le résultat d'une recherche.
     * @param p Le produit trouvé (ou null).
     * @param terme Le mot-clé utilisé pour la recherche.
     */

    public void afficherResultatRecherche(Produit p, String terme){
        System.out.println("\n========================================================");
        System.out.println("            RESULTAT DE LA RECHERCHE : " + terme);
        System.out.println("========================================================");

        if (p != null) {
            System.out.println("Produit trouvé !");
            System.out.println("NOM      : " + p.getNom());
            System.out.println("DOMAINE  : " + p.getDomaine());
            System.out.printf("PRIX     : %.1f EUR %n", p.getPrix());
        } else {
            System.out.println("Information : Aucun produit ne correspond au domaine '" + terme + "'.");
        }
        System.out.println("========================================================\n");
    }
}
