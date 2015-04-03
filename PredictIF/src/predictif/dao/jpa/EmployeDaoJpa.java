
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
 * Classe jpa d'employé implémentant les méthodes de la couche DAO
 * @author Alexis Papin & Quentin Bayart
 */

public class EmployeDaoJpa implements EmployeDao 
{
/*----------------------------------CONSTRUCTEURS---------------------------------*/
    /**
     * Constructeur par défaut
     */
    public EmployeDaoJpa () {}
    
    
/*-----------------------------------METHODES-------------------------------------*/
    /**
     * Créé un émployé
     * @param unEmploye un employé
     */
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

    /**
     * Renvoie un employé à partir d'un pseudo et d'un mot de passe
     * @param unPseudo un pseudo
     * @param unMdp un mot de passe
     * @return un employé
     */
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
    
    /**
     * Ajoute un client à un employé
     * @param emp un employé
     * @param unClient un client
     */
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
    
    /**
     * Renvoie une liste de tous les employés de Predictif
     * @return une liste d'employés
     */
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
