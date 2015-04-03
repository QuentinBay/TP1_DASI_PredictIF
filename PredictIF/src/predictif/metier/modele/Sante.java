
package predictif.metier.modele;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 * Classe de l'objet métier prédiction santé
 * @author Alexis Papin & Quentin Bayart
 */
@Entity
public class Sante extends Prediction
{
    /**
     * Un conseil
     */
    private String conseil;

    /*------------------------------------ Getters et Setters ---------------------------*/
    /**
     * 
     * @return 
     */
    public String getConseil() {
        return conseil;
    }

    /**
     * 
     * @param conseil 
     */
    public void setConseil(String conseil) {
        this.conseil = conseil;
    }
   

    
    /* --------------------------------------- CONSTRUCTEURS ---------------------------------- */
    /**
     * Constructeur par défaut
     */
    public Sante () {}
    
    /**
     * Créé une prédiction de santé
     * @param numero un numéro
     * @param positivite une positivité
     * @param prevision une prévision
     * @param icone une icone
     * @param unConseil un conseil
     */
    public Sante ( int numero, int positivite, String prevision, String icone, String unConseil)
    {
        super( numero, positivite, prevision, icone);
        conseil=unConseil;
        type="Sante";
    }
    
    /**
     * @return Une représentation textuelle de la prédiction
     */
    public String toString() {
        return super.toString() + " **" + conseil + "**";
    }
}