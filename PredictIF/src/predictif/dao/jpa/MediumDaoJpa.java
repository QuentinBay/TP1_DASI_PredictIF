/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author quentin
 */

public class MediumDaoJpa implements MediumDao
{
/* --------------------------------------- CONSTRUCTEURS --------------------------------------- */
    public MediumDaoJpa () {}
    
/* ----------------------------------------- METHODES ------------------------------------------ */
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

    @Override
    public Medium miseAJourMedium(Medium unMedium) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerMedium(Medium unMedium) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medium trouverMediumAvecPseudo(String unPseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
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

    @Override
    public List<Medium> trouverTousMediums() {
        Query query= JpaUtil.obtenirEntityManager().createQuery(
                "select c from Medium c");
        
        //query.setParameter("empMotDePasse", unMdp);
        List<Medium> result = (List<Medium>)query.getResultList();
        if (!result.isEmpty())
        {
            return result;
        }
        else
        {
            /*ATTENTION : Si on ne trouve pas l employe*/
            return null;
        }
    }
    
}
