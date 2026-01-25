package modele;

/**
 * Héritage de la class Produit
 * Création des Spiritueux
 */

/**
 * Classe représentant un produit de type Spiritueux.
 */

public class Spiritueux extends Produit {

    /**
     * Constructeur de la classe Spiritueux.
     * @param type Catégorie de boisson.
     * @param domaine Nom du producteur.
     * @param nomProduit Nom de la bouteille.
     * @param prix Tarif unitaire.
     * @param mentions Mentions légales.
     */

    public Spiritueux(String type, String domaine, String nomProduit, float prix, MentionLegal mentions) {
        //On donne les données au parent
        super(type, domaine, nomProduit, prix, mentions);
    }
}
