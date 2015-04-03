
package predictif.metier.modele;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 * Classe de l'objet métier prédiction travail
 * @author Alexis Papin & Quentin Bayart
 */
@Entity
public class Travail extends Prediction
{
    

    /*------------------------------------ Getters et Setters ---------------------------*/
   

    
    /* --------------------------------------- CONSTRUCTEURS ---------------------------------- */
    /**
     * Constructeur par défaut
     */
    public Travail () {}
    
    /**
     * Cree une prediction de travail
     * @param numero Son texte
     * @param positivite Sa positivite
     * @param prevision Sa description
     * @param icone Son icone
     */
    public Travail (int numero, int positivite, String prevision, String icone)
    {
        super( numero, positivite, prevision, icone);
        type="Travail";
    }
}