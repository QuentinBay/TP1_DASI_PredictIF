/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.dao.jpa;

import predictif.dao.SigneAstrologiqueDao;
import predictif.metier.modele.SigneAstrologique;
import javax.persistence.EntityManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

/**
 *
 * @author quentin
 */
public class SigneAstrologiqueDaoJpa implements SigneAstrologiqueDao 
{
    
/* --------------------------------------- CONSTRUCTEURS --------------------------------------- */
    
    public SigneAstrologiqueDaoJpa () {}
    
    
/* ----------------------------------------- METHODES ------------------------------------------ */
    
    @Override
    public void creerTousLesSignesAstrologiques() 
    //On cree tous les signes astrologiques car ceux sont 12 entites predefinies
    {
        JpaUtil.log("debut transaction : creerTousLesSignesAstrologiques");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            
            SigneAstrologique signe;
            for(int i=0; i<12; i++)
            {
                signe=new SigneAstrologique(i);
                em.persist(signe);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public SigneAstrologique trouverSigneAstrologiqueAvecDate(Date uneDate) 
    {
        int mois = uneDate.getMonth();
        /*switch(mois) {
            case 0:
                    signe = "Capricorne";
                // Renvoyer signe capricorne
                    break;
            case 1:
                    signe = "Verseau";
                    break;
            case 2:
                    signe = "Poisson";
                    break;
            case 3:
                    signe = "Belier";
                    break;
            case 4:
                    signe = "Taureau";
                    break;
            case 5:
                    signe = "Gemeaux";
                    break;
            case 6:
                    signe = "Cancer";
                    break;
            case 7:
                    signe = "Lion";
                    break;
            case 8:
                    signe = "Vierge";
                    break;
            case 9:
                    signe = "Balance";
                    break;
            case 10:
                    signe = "Scorpion";
                    break;
            case 11:
                    signe = "Sagitaire";
                    break;*/
        return null;
    }
    
}
