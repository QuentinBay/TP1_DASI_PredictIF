
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
public class Amour extends Prediction {
    
    @ManyToOne
    private SigneAstrologique partenaire;

    /*------------------------------------ Getters et Setters ---------------------------*/
   

    
    /* --------------------------------------- CONSTRUCTEURS ---------------------------------- */
    public Amour () {}
    
    public Amour (int numero, int positivite, String prevision, String icone, SigneAstrologique signe)
    {
        super( numero, positivite, prevision, icone);
        partenaire=signe;
    }
}