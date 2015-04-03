

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.metier.modele;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author qbayart
 */
@Entity
public class Travail extends Prediction
{
    

    /*------------------------------------ Getters et Setters ---------------------------*/
   

    
    /* --------------------------------------- CONSTRUCTEURS ---------------------------------- */
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