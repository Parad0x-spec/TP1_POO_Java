import java.util.Scanner;
import java.util.Locale;
import java.util.InputMismatchException;
import controleur.CatalogueControleur;
import modele.*;
import vue.CatalogueVue;

/**
 *  Source architecture :
 *  https://www.baeldung.com/java-21-unnamed-class-instance-main
 */

void main() {
    /**
    // Test pour l'exercice 1 et simulé une recherhe pour l'exercice 2
    // Données initiales
    String[] noms = {"Cognac", "Armagnac", "Calvados"};
    float[] prix = {207.3f, 53.4f, 78.4f};

    // Initialisation
    CatalogueControleur ctrl = new CatalogueControleur();
    CatalogueVue vue = new CatalogueVue();

    // objets et affichage
    Produit[] catalogue = ctrl.initialiserStoock();
    vue.afficherCatalogue(catalogue);

    // Test de recherche (Exemple : on cherche Margaux)
    String recherche = "Château Margaux";
    Produit resultat = ctrl.rechercherParDomaine(catalogue, recherche);

    // Affichage du résultat
    vue.afficherResultatRecherche(resultat, recherche);
    */

    // Test de recherhce avec scanner

    CatalogueControleur ctrl = new CatalogueControleur();
    CatalogueVue vue = new CatalogueVue();
    Scanner clavier = new Scanner(System.in);
    clavier.useLocale(Locale.FRENCH);

    // Le panier est créé ici une seule fois pour toute la session
    Panier monPanier = new Panier();

    Produit[] catalogue = ctrl.initialiserStock();
    int choix = 0;

    do {
        System.out.println("\n--- GESTION DU STOCK ---");
        System.out.println("1. Afficher le catalogue");
        System.out.println("2. Rechercher et modifier un prix");
        System.out.println("3. Rechercher et supprimer un produit");
        System.out.println("4. Ajouter une reference");
        System.out.println("5. Passer une commande (Vente)");
        System.out.println("6. Quitter");
        System.out.println("7. Imprimer le ticket final");
        System.out.print("Votre choix : ");

        try {
            choix = clavier.nextInt();
            clavier.nextLine();

            switch (choix) {
                case 1:
                    vue.afficherCatalogue(catalogue);
                    break;

                case 2:
                    System.out.print("Nom du domaine à modifier : ");
                    String domaineModif = clavier.nextLine();
                    Produit pModif = ctrl.rechercherParDomaine(catalogue, domaineModif);
                    if (pModif != null) {
                        System.out.print("Nouveau prix : ");
                        float prix = clavier.nextFloat();
                        ctrl.mettreAJourPrix(pModif, prix);
                        vue.afficherResultatRecherche(pModif, "Prix mis à jour");
                    } else {
                        System.out.println("Erreur : Produit introuvable.");
                    }
                    break;

                case 3:
                    System.out.print("Nom du domaine à supprimer : ");
                    String domaineSuppr = clavier.nextLine();
                    Produit pSuppr = ctrl.rechercherParDomaine(catalogue, domaineSuppr);
                    if (pSuppr != null) {
                        ctrl.supprimerProduit(catalogue, pSuppr);
                    } else {
                        System.out.println("Erreur : Impossible de supprimer un produit inexistant.");
                    }
                    break;

                case 4:
                    catalogue = ctrl.agrandirStock(catalogue);
                    boolean ajoutEnCours = true;
                    while (ajoutEnCours) {
                        try {
                            System.out.println("\n--- NOUVEL AJOUT (tapez 'quitter' pour annuler) ---");
                            System.out.print("Type (Vin/Spiritueux) : ");
                            String type = clavier.nextLine();
                            if(type.equalsIgnoreCase("quitter")) break;
                            System.out.print("Domaine : ");
                            String dom = clavier.nextLine();
                            System.out.print("Nom du produit : ");
                            String nom = clavier.nextLine();
                            System.out.print("Prix HT (ex: 14,3) : ");
                            float px = clavier.nextFloat();
                            clavier.nextLine();
                            System.out.print("Degré d'alcool (ex: 13,5) : ");
                            float alc = clavier.nextFloat();
                            clavier.nextLine();
                            System.out.print("Description : ");
                            String desc = clavier.nextLine();

                            int stockInitial = 10;
                            Produit nouveau;
                            if (type.equalsIgnoreCase("Vin")) {
                                System.out.print("Couleur : ");
                                String couleur = clavier.nextLine();
                                nouveau = new Vin(type, dom, nom, px, new MentionLegal(alc, desc), couleur, stockInitial);
                            } else {
                                nouveau = new Spiritueux(type, dom, nom, px, new MentionLegal(alc, desc), stockInitial);
                            }

                            if (ctrl.ajouterProduit(catalogue, nouveau)) {
                                System.out.println("Système : Produit ajouté !");
                            }
                            ajoutEnCours = false;

                        } catch (InputMismatchException e) {
                            System.out.println("ERREUR : Format numérique invalide.");
                            clavier.nextLine();
                            ajoutEnCours = false;
                        }
                    }
                    break;

                case 5:
                    System.out.print("Domaine recherché : ");
                    String domC = clavier.nextLine();
                    Produit pC = ctrl.rechercherParDomaine(catalogue, domC);
                    if (pC != null) {
                        System.out.print("Quantité souhaitée : ");
                        int qte = clavier.nextInt();
                        clavier.nextLine();
                        if (ctrl.verifierDisponibilite(pC, qte)) {
                            ArticlePanier nouvelArticle = new ArticlePanier(pC, qte, 0.75f);
                            System.out.println("\n--- APPLIQUER UNE RÉDUCTION ---");
                            System.out.println("1. Aucune");
                            System.out.println("2. Réduction immédiate (5%)");
                            System.out.println("3. Promotion (15%)");
                            System.out.println("4. Dégustation / Perte (100%)");
                            System.out.print("Votre choix : ");
                            int choixReduc = clavier.nextInt();
                            clavier.nextLine();
                            switch (choixReduc) {
                                case 2: nouvelArticle.appliquerRemise(0.05f); break;
                                case 3: nouvelArticle.appliquerRemise(0.15f); break;
                                case 4: nouvelArticle.appliquerRemise(1.00f); break;
                            }
                            monPanier.ajouterArticle(nouvelArticle);
                            pC.retirerStock(qte);
                            System.out.println("Système : Article ajouté au panier.");
                        }else {
                            System.out.println("Attention : Commander de nouvelle bouteille (Disponible : " + pC.getQuantiteStock() + ").");
                        }
                    } else {
                        System.out.println("NON : Le domaine '" + domC + "' n'existe pas dans le catalogue.");
                    }
                    break;

                case 6:
                    System.out.println("Fermeture du programme... Au revoir !");
                    choix = 6;
                    break;

                case 7:
                    // Logique de fidélité avant impression
                    System.out.print("Utiliser les points de fidélité ? (1: Oui / 2: Non) : ");
                    int utiliserFid = clavier.nextInt();
                    clavier.nextLine();
                    float remiseFid = 0;
                    if (utiliserFid == 1) {
                        // On simule 100 points pour le test (100 pts = 1.00€)
                        int pointsClient = 100; // Exemple
                        remiseFid = (pointsClient / 10.0f) * 0.10f;
                        System.out.printf("Remise fidélité appliquée : %.2f€ %n", remiseFid);
                    }
                    vue.genererTicket(monPanier, remiseFid);
                    // On peut réinitialiser le panier pour une nouvelle vente après le ticket
                    monPanier = new Panier();
                    break;

                default:
                    System.out.println("Choix invalide.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erreur : Saisie invalide.");
            clavier.nextLine();
        }
    } while (choix != 6);
    clavier.close();
}

