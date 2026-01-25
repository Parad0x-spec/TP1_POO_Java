package modele;

/**
 * Pour un vendeur les mentions légal sont importante car ca lui permet de mieux connaitre son produit.
 * De plus l'acheteur a besoin de cette description si il souhaite faire un tric pour trouver la bonne réferance
 */

/**
 * Représente les informations légales obligatoires.
 */

public class MentionLegal {
    private float degreAlcool;
    private String description;

    /**
     * Initialise les mentions légales d'un produit.
     * @param degreAlcool Le pourcentage d'alcool (ex: 13.5).
     * @param description Les notes de dégustation.
     */

    public MentionLegal(float degreAlcool, String description) {
        this.degreAlcool = degreAlcool;
        this.description = description;

    }

    /**
     * utilisattion du getter pour récureper les données
     */

    /**
     * Accesseur pour le degré d'alcool.
     * @return Le degré d'alcool du produit sous forme de float.
     */

    public float getDegreAlcool() {
        return degreAlcool;
    }

    /**
     * Récupère la description des mentions légales.
     * @return La chaîne de caractères descriptive.
     */

    public String getDescription() {
        return description;
    }
}
