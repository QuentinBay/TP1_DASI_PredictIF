
package predictif.dao;

import predictif.metier.modele.SigneAstrologique;

import java.util.Date;


/**
 * Interface DAO de SigneAstrologique
 * @author Alexis Papin & Quentin Bayart
 */


public interface SigneAstrologiqueDao 
{
    /**
     * Créé les 12 signes asstrologiques
     */
    public void creerTousLesSignesAstrologiques ();
    
    /**
     * Renvoie un signe astrologique en fonction d'un mois
     * @param mois un mois
     * @return un signe astrologique
     */
    public SigneAstrologique trouverSigneAstrologiqueAvecMois (int mois);
}

