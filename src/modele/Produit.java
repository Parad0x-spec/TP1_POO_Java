package modele;

/**
 * Class Produit
 * Dans l'énoncer il y a marquée double[] prix alors qu'il faut utoilisé des float
 */

public abstract class Produit { // force la class a donner la logique
    private String type;
    private String domaine;
    private String nomProduit;
    private float prix;
    private MentionLegal mentions;

    /**
     * Constructeur de la classe Produit.
     * @param type Vin ou Spiritueux.
     * @param domaine Nom du domaine viticole.
     * @param nomProduit Nom commercial.
     * @param prix Prix de vente.
     * @param mentions Détails légaux (alcool, description).
     */

    public Produit(String type,String domaine,String nomProduit, float prix, MentionLegal mentions) {
        this.type = type;
        this.domaine = domaine;
        this.nomProduit = nomProduit;
        this.prix = prix;
        this.mentions = mentions;
    }

    /**
     * Récupère le type du produit.
     * @return La catégorie (Vin ou Spiritueux).
     */

    public String getType() {
        return type;
    }

    /**
     * Accesseur pour le domaine.
     * @return Le nom du domaine viticole.
     */

    public String getDomaine() {
        return domaine;
    }
    /**
     * Obtient le nom du produit.
     * @return Le nom commercial sous forme de chaîne.
     */

    public String getNom() {
        return nomProduit;
    }

    /**
     * Récupère le prix actuel du produit.
     * @return Le prix sous forme de nombre flottant.
     */

    public float getPrix() {
        return prix;
    }

    /**
     * Récupère l'objet des mentions légales du produit.
     * @return Un objet MentionLegal.
     */

    public MentionLegal getMentions() {
        return mentions;
    }

    /**
     * Modifie le prix du produit.
     * @param nouveauPrix Le nouveau montant à enregistrer.
     */

    // À ajouter dans Produit.java
    public void setPrix(float nouveauPrix) {
        this.prix = nouveauPrix;
    }
}