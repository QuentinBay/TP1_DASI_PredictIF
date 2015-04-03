
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.metier.modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.*;

/**
 *
 * @author qbayart
 */
@Entity
public class Amour extends Prediction
{
    
    @ManyToOne
    private SigneAstrologique partenaire;

    /*------------------------------------ Getters et Setters ---------------------------*/

    public SigneAstrologique getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(SigneAstrologique partenaire) {
        this.partenaire = partenaire;
    }
   

    
    /* --------------------------------------- CONSTRUCTEURS ---------------------------------- */
    public Amour () {}
    
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