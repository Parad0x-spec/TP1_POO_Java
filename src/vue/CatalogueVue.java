package vue;

import modele.Produit;
import modele.Vin;
import modele.Spiritueux;
import modele.Panier;
import modele.ArticlePanier;
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

    /**
     * Génère le ticket de caisse final.
     * @param panier Le panier contenant les articles.
     * @param remiseFidHT Le montant de la remise fidélité appliquée en euros HT.
     */

    public void genererTicket(Panier panier, float remiseFidHT) {
        // Logo
        System.out.println("                      __");
        System.out.println("                    <(o )___");
        System.out.println("                    ( ._> /");
        System.out.println("                     `---'");

        System.out.println("\n********************************************************");
        System.out.println("                TICKET DE CAISSE ");
        System.out.println("********************************************************");

        float totalHT = 0;

        for (ArticlePanier art : panier.getArticles()) {
            Produit p = art.getProduit();
            float prixBrutHT = p.getPrix() * art.getQuantite();
            float remiseArtHT = art.getRemiseAppliquee();
            float sousTotalHT = prixBrutHT - remiseArtHT; // CORRECTION : On soustrait ici

            System.out.println("PRODUIT  : " + p.getDomaine() + " [" + p.getNom() + "]");
            System.out.println("QUANTITE : " + art.getQuantite());
            System.out.printf("PRIX BRUT: %.2f EUR HT %n", prixBrutHT);

            if (remiseArtHT > 0) {
                System.out.printf("REMISE   : -%.2f EUR HT %n", remiseArtHT);
            }

            System.out.printf("SOUS-TOTAL: %.2f EUR HT %n", sousTotalHT);
            System.out.println("--------------------------------------------------------");
            totalHT += sousTotalHT;
        }

        // Calcul final avec TVA
        float totalApresFidHT = totalHT - remiseFidHT;
        float montantTVA = totalApresFidHT * 0.20f;
        float totalTTC = totalApresFidHT + montantTVA;

        System.out.printf("TOTAL GENERAL HT : %.2f EUR %n", totalHT);
        if(remiseFidHT > 0) System.out.printf("REMISE FIDELITE : -%.2f EUR HT %n", remiseFidHT);
        System.out.printf("MONTANT TVA (20%%): %.2f EUR %n", montantTVA);
        System.out.printf("TOTAL A PAYER TTC: %.2f EUR %n", totalTTC);
        System.out.println("POINTS FIDELITE GAGNES : " + (int)totalHT);
        System.out.println("********************************************************\n");
    }
}
