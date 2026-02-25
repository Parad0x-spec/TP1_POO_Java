package modele;

import java.util.ArrayList;
import java.util.List;


 /**
  * Constructeur principal
 */

public class Panier {
    private List<ArticlePanier> articles;
    private int  pointsFideliteGagnes;
    private int pointsUtilises;

     /**
      * Constructeur de la classe Panier.
      * Initialise un nouveau panier vide.
      */

    public Panier() {
        this.articles = new ArrayList<>();
        this.pointsFideliteGagnes = 0;
        this.pointsUtilises = 0;
    }

    /**
     * Ajoute une nouvelle ligne de produit au panier
     * @param article L'objet contenant le produit, la quantité et la contenance
     */
    public void ajouterArticle(ArticlePanier article) {
        if (article != null) {
            this.articles.add(article);
            // On calcule aussi les points gagnés pour cet achat
            this.pointsFideliteGagnes += (int) article.getSousTotal();
        }
    }

    /**
     * Calcul du montant HT du panier (si deduction TVA)
     * @return somme des sous-totaux
     */

    public float calculeTotalBrut() {
        float total = 0;
        for (ArticlePanier a : articles) {
            total += a.getSousTotal();
        }
        return total;
    }

    /**
     * Permet de calculé la réduction avec les points de fidelite
     * @param points Le nombre points sont convertis (10 pts = 0.10€)
     * @return le montant de la remise
     */

    public float convertirPointsEnRemise(int points) {
        this.pointsUtilises = points;
        return (points / 10.0f) * 0.10f;
    }

    /**
     * Récupère la liste des articles.
     * @return La liste des articles présents dans le panier.
     */

    // Getter pour le ticket final
    public List<ArticlePanier> getArticles() { return articles; }

    /**
     * Récupère le total des points.
     * @return Le cumul des points de fidélité gagnés lors de cette vente.
     * */

    public int getPointsFideliteGagnes() { return pointsFideliteGagnes; }

}
