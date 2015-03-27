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

/**
 *
 * @author quentin
 */

public class EmployeDaoJpa implements EmployeDao 
{
/* --------------------------------------- CONSTRUCTEURS --------------------------------------- */
    
    public EmployeDaoJpa () {}
    
    
/* ----------------------------------------- METHODES ------------------------------------------ */
    @Override
    public void creerEmploye(Employe unEmploye) {
        JpaUtil.log("debut transaction");
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
        return (result.get(0));
    }
    
}
