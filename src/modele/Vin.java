package modele;

/**
 * Héritage de la class Produit
 * Création de la class Vin
 */

public class Vin extends Produit {
    private String couleur; // ex : Rouge, Blanc, Rosé

    /**
     * Constructeur de la classe Vin.
     * @param type Type du produit.
     * @param domaine Nom du domaine.
     * @param nomproduit Nom de la cuvée.
     * @param prix Prix unitaire.
     * @param mentions Mentions légales associées.
     * @param couleur Couleur du vin (Rouge, Blanc, Rosé).
     * @param quantiteStock Le stock initial de bouteilles de vin.
     */

    public Vin(String type, String domaine, String nomproduit, float prix, MentionLegal mentions, String couleur, int quantiteStock) {
        super(type, domaine, nomproduit, prix, mentions, quantiteStock);
        this.couleur = couleur;
    }

    /**
     * Obtient la couleur du vin.
     * @return La couleur (Rouge, Blanc ou Rosé).
     */

    public String getCouleur() {
        return couleur;
    }
}
