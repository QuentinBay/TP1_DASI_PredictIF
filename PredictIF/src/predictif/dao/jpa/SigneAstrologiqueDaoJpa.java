
package predictif.dao.jpa;

import predictif.dao.SigneAstrologiqueDao;
import predictif.metier.modele.SigneAstrologique;
import javax.persistence.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.util.List;

/**
 * Classe Jpa de SigneAstrologique qui implémente les métodes de la couche DAO
 * @author Alexis Papin & Quentin Bayart
 */
public class SigneAstrologiqueDaoJpa implements SigneAstrologiqueDao 
{
    
/*----------------------------------CONSTRUCTEURS---------------------------------*/
    public SigneAstrologiqueDaoJpa () {}
    
    
/*-------------------------------------METHODES-----------------------------------*/
    /**
     * Créé les 12 signes asstrologiques
     */
    @Override
    public void creerTousLesSignesAstrologiques() 
    //On cree tous les signes astrologiques car ceux sont 12 entites predefinies
    {
        JpaUtil.log("debut transaction : creerTousLesSignesAstrologiques");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            
            SigneAstrologique signe;
            for(int i=0; i<=11; i++)
            {
                signe=new SigneAstrologique(i);
                em.persist(signe);
            }
            
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Renvoie un signe astrologique en fonction d'un mois
     * @param mois un mois
     * @return un signe astrologique
     */
    @Override
    public SigneAstrologique trouverSigneAstrologiqueAvecMois(int mois) 
    {
        JpaUtil.log("Transaction : trouverSigneAstrologiqueAvecMois");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            Query q = em.createQuery("select e from SigneAstrologique e where e.mois =:eMois");
            q.setParameter("eMois", mois);
            
            List<SigneAstrologique> result = (List<SigneAstrologique>)q.getResultList();
            if (!result.isEmpty())
            {
                return (result.get(0));
            }
            return null;
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
