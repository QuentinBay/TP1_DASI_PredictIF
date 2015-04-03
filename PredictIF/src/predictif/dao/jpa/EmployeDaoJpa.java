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
        JpaUtil.log("EmployeDaoJpa : creerEmploye");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            em.persist(unEmploye);
        } catch (Exception ex) {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public Employe trouverEmployeAvecPseudoEtMdp(String unPseudo, String unMdp) 
    {
        JpaUtil.log("EmployeDaoJpa : trouverEmployeAvecPseudoEtMdp");
        try {
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
            return null;
        } catch (Exception ex) {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
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
        JpaUtil.log("EmployeDaoJpa : moinsDeClients");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            Query q = em.createQuery("SELECT e FROM Employe e ORDER BY size(e.clients)").setMaxResults(1);
            return (Employe) q.getSingleResult();
        } catch (Exception ex) {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
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
    
    @Override
    public List<Employe> listerEmployes ()
    {
        JpaUtil.log("EmployeDaoJpa : listerEmployes");
        try {
            Query query= JpaUtil.obtenirEntityManager().createQuery("select e from Employe e");

            List<Employe> result = (List<Employe>)query.getResultList();
            if (!result.isEmpty())
            {
                return result;
            }
            return null;
        } catch (Exception ex) {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
