/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.dao;

import predictif.metier.modele.SigneAstrologique;

import java.util.Date;


/**
 *
 * @author qbayart
 */


public interface SigneAstrologiqueDao 
{
    public void creerTousLesSignesAstrologiques ();
    //public SigneAstrologique miseAJourSigneAstrologique (SigneAstrologique unSigneAstrologique);
    //public void supprimerSigneAstrologique (SigneAstrologique unSigneAstrologique);
    public SigneAstrologique trouverSigneAstrologiqueAvecMois (int mois);
}

