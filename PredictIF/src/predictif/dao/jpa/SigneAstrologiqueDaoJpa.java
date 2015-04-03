/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.dao.jpa;

import predictif.dao.SigneAstrologiqueDao;
import predictif.metier.modele.SigneAstrologique;
import javax.persistence.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.util.List;

/**
 *
 * @author quentin
 */
public class SigneAstrologiqueDaoJpa implements SigneAstrologiqueDao 
{
    
/*----------------------------------CONSTRUCTEURS---------------------------------*/
    public SigneAstrologiqueDaoJpa () {}
    
    
/*-------------------------------------METHODES-----------------------------------*/
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
            else
            {
                /*ATTENTION : Si on ne trouve pas l employe*/
                return null;
            }
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
