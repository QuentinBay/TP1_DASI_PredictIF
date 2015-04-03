/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.dao.jpa;

import java.util.List;
import predictif.dao.EmployeDao;
import predictif.metier.modele.Employe;
import javax.persistence.EntityManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import predictif.metier.modele.Client;

/**
 *
 * @author quentin
 */

public class EmployeDaoJpa implements EmployeDao 
{
/*----------------------------------CONSTRUCTEURS---------------------------------*/
    
    public EmployeDaoJpa () {}
    
    
/*-----------------------------------METHODES-------------------------------------*/
    @Override
    public void creerEmploye(Employe unEmploye) {
        JpaUtil.log("debut transaction : creerEmploye");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            em.persist(unEmploye);
        } catch (Exception ex) {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Employe miseAJourEmploye(Employe unEmploye) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerEmploye(Employe unEmploye) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employe trouverEmployeAvecPseudoEtMdp(String unPseudo, String unMdp) 
    {
        Query query= JpaUtil.obtenirEntityManager().createQuery(
                "select e from Employe e where e.pseudo=:empPseudo "
                                        + "and e.motDePasse=:empMotDePasse");
        
        query.setParameter("empPseudo", unPseudo);
        query.setParameter("empMotDePasse", unMdp);
        List<Employe> result = (List<Employe>)query.getResultList();
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
    
    /**
     * Trouve l employe qui a le moins de clients
     * @return l employe
     */
    @Override
    public Employe moinsDeClients()
    {
        JpaUtil.log("debut transaction : creerEmploye");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            Query q = em.createQuery("SELECT e FROM Employe e ORDER BY size(e.clients)").setMaxResults(1);
            return (Employe) q.getSingleResult();
        } catch (Exception ex) {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void ajouterClient (Employe emp,Client unClient)
    {
        JpaUtil.log("EmployeDaoJpa : ajouterClient");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            
            //Lier une liste de mediums a un client
            emp.addClient(unClient);
            em.merge(emp);
            
        } catch (Exception ex) {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
