
package predictif.metier.modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.*;

/**
 * Classe objet métier prédiction amoureuse
 * @author Alexis Papin & Quentin Bayart
 */
@Entity
public class Amour extends Prediction
{
    /**
     * Signe astrologique du partenaire amoureux
     */
    @ManyToOne
    private SigneAstrologique partenaire;

    /*------------------------------------ Getters et Setters ---------------------------*/
    /**
     * Renvoie le signe astrologique du partenaire
     * @return un signe astrologique
     */
    public SigneAstrologique getPartenaire() {
        return partenaire;
    }

    /**
     * Met à jour le signe astrologique du partenaire
     * @param partenaire un signe astrologique
     */
    public void setPartenaire(SigneAstrologique partenaire) {
        this.partenaire = partenaire;
    }
   

    
    /* --------------------------------------- CONSTRUCTEURS ---------------------------------- */
    /**
     * Constructeur par défaut
     */
    public Amour () {}
    
    /**
     * Créer une prédiction amoureuse
     * @param numero un numéro
     * @param positivite une positivité
     * @param prevision une prévision
     * @param icone une icône
     */
    public Amour (int numero, int positivite, String prevision, String icone)
    {
        super( numero, positivite, prevision, icone);
        partenaire=null;
        type="Amour";
    }

    /**
     * @return Une représentation textuelle de la prédiction
     */
    public String toString() {
        return super.toString() + " **" + partenaire.getSigne() + "**";
    }
    
}