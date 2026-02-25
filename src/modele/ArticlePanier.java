package modele;

/**
 * Classe représentant une ligne d'article dans le panier.
 */

public class ArticlePanier {
    private Produit produit;
    private int quantite;
    private float contenanceLitre; // ex: 0.75 pour 75cl
    private float remiseAppliquee; // en €

    /**
     * Constructeur de l'article panier.
     * @param produit Le produit sélectionné du catalogue.
     * @param quantite La quantité commandée.
     * @param contenanceLitre La contenance de la bouteille.
     */

    public ArticlePanier(Produit produit, int quantite, float contenanceLitre) {
        this.produit = produit;
        this.quantite = quantite;
        this.contenanceLitre = contenanceLitre;
        this.remiseAppliquee = 0.0f;
    }

    /** Il permet d'appliquer un % de reduction sur l'article
    * @param pourcentage 0.15 = 15%
    */

    public void appliquerRemise(float pourcentage) {
        this.remiseAppliquee = (produit.getPrix() * quantite) * pourcentage;
    }

    /**
     * Getters nécessaires pour le ticket
     * @return Le produit associé à cet article.
     */

    public Produit getProduit() { return produit; }

    /**
     *Getters nécessaires pour produit
     * @return La quantité commandée.
     */

    public int getQuantite() { return quantite; }

    /**
     * Pas encore utilisé c'est juste une idée
     * @return La contenance en litres.
     */

    public float getContenanceLitre() { return contenanceLitre; }

    /**
     * Calcule le prix total pour cette ligne.
     * @return prix unitaire * quantité.
     */

    public float getSousTotal() {
        return produit.getPrix() * quantite;
    }

    /**
     * Récupère le montant de la remise calculée pour cet article.
     * @return le montant de la réduction en euros.
     */

    public float getRemiseAppliquee() {
        return this.remiseAppliquee;
    }
}
