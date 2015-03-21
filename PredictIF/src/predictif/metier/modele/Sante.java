
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
public class Sante extends Prediction
{
    private String conseil;

    /*------------------------------------ Getters et Setters ---------------------------*/
   

    
    /* --------------------------------------- CONSTRUCTEURS ---------------------------------- */
    public Sante () {}
    
    public Sante ( int numero, int positivite, String prevision, String icone, String unConseil)
    {
        super( numero, positivite, prevision, icone);
        conseil=unConseil;
    }
}