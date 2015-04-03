
package predictif.dao.jpa;

import predictif.dao.MediumDao;
import predictif.metier.modele.Medium;
import javax.persistence.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.Vector;
import predictif.metier.modele.Client;

/**
 * Classe jpa de médium qui implémente les méthodes de la couche DAO
 * @author Alexis Papin & Quentin Bayart
 */

public class MediumDaoJpa implements MediumDao
{
/* --------------------------------------- CONSTRUCTEURS --------------------------------------- */
    /**
     * Constructeur par défaut
     */
    public MediumDaoJpa () {}
    
/* ----------------------------------------- METHODES ------------------------------------------ */
    /**
     * Créé un médium
     * @param unMedium un médium
     */
    @Override
    public void creerMedium(Medium unMedium) {
        JpaUtil.log("MediumDaoJpa : creerMedium");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            em.persist(unMedium);
        } catch (Exception ex) {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Renvoie un médium à partir d'un identifiant
     * @param unID un identifiant
     * @return un médium
     */
    @Override
    public Medium trouverMediumAvecID(long unID){
        JpaUtil.log("MediumDaoJpa : trouverMediumAvecID");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            return em.find(Medium.class, unID);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Renvoie la liste de tous les médiums
     * @return une liste de médiums
     */
    @Override
    public List<Medium> trouverTousMediums() {
        JpaUtil.log("MediumDaoJpa : trouverTousMediums");
        try {
            Query query= JpaUtil.obtenirEntityManager().createQuery(
                "select c from Medium c");

            List<Medium> result = (List<Medium>)query.getResultList();
            if (!result.isEmpty())
            {
                return result;
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
