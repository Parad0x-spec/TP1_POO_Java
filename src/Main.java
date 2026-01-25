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
    clavier.useLocale(Locale.US);

    Produit[] catalogue = ctrl.initialiserStock();
    int choix = 0;

    // Boucle principale du programme
    do {
        System.out.println("\n--- GESTION DU STOCK ---");
        System.out.println("1. Afficher le catalogue");
        System.out.println("2. Rechercher et modifier un prix");
        System.out.println("3. Rechercher et supprimer un produit");
        System.out.println("4. Ajouter une reference");
        System.out.println("5. Quitter");
        System.out.print("Votre choix : ");

        try {
            choix = clavier.nextInt();
            clavier.nextLine(); // Nettoyage du buffer

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

                case 4: // AJOUTER UN PRODUIT
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

                            // Saisie sécurisée du prix
                            System.out.print("Prix (ex: 14.3) : ");
                            float px = clavier.nextFloat();

                            // Saisie sécurisée de l'alcool
                            System.out.print("Degré d'alcool (ex: 13.5) : ");
                            float alc = clavier.nextFloat();
                            clavier.nextLine(); // Nettoyage buffer obligatoire

                            System.out.print("Description : ");
                            String desc = clavier.nextLine();

                            Produit nouveau;
                            if (type.equalsIgnoreCase("Vin")) {
                                System.out.print("Couleur : ");
                                String couleur = clavier.nextLine();
                                nouveau = new Vin(type, dom, nom, px, new MentionLegal(alc, desc), couleur);
                            } else {
                                nouveau = new Spiritueux(type, dom, nom, px, new MentionLegal(alc, desc));
                            }

                            if (ctrl.ajouterProduit(catalogue, nouveau)) {
                                System.out.println("Système : Produit ajouté !");
                            } else {
                                System.out.println("Erreur : Stock saturé.");
                            }
                            ajoutEnCours = false; // On sort de la boucle d'ajout

                        } catch (InputMismatchException e) {
                            System.out.println("ERREUR : Format numérique invalide (utilisez le POINT).");
                            System.out.println("1. Réessayer / 2. Revenir au menu principal");
                            clavier.nextLine(); // Nettoyage suite à l'erreur
                            if (clavier.nextLine().equals("2")) ajoutEnCours = false;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Fermeture du programme... Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide. Veuillez saisir un nombre entre 1 et 5.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erreur : Veuillez saisir un nombre valide.");
            clavier.nextLine(); // Vide le scanner pour éviter une boucle infinie
        }

    } while (choix != 5
    );

    clavier.close();
}

