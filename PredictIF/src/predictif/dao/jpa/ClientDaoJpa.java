/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.dao.jpa;

import predictif.dao.ClientDao;
import predictif.dao.SigneAstrologiqueDao;
import predictif.metier.modele.Client;
import predictif.metier.modele.SigneAstrologique;
import javax.persistence.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import predictif.metier.modele.Medium;

/**
 *
 * @author qbayart
 */
public class ClientDaoJpa implements ClientDao {

    /* --------------------- CONSTRUCTEURS ---------------------------------- */
    
    public ClientDaoJpa() {}
    
    /* ------------------------ METHODES ------------------------------------ */

    @Override
    public void creerClient(Client unClient) {
        JpaUtil.log("ClientDaoJpa : creerClient");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            em.persist(unClient);
            
            //Lier un signe astrologique a un client
            SigneAstrologiqueDao monGESigne = new SigneAstrologiqueDaoJpa();
            int moisClient = unClient.getDateNaissance().getMonth();
            SigneAstrologique signe = monGESigne.trouverSigneAstrologiqueAvecMois(moisClient);
            unClient.setSigne(signe);
            
        } catch (Exception ex) {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void choisirMediums(Client unClient, List<Medium> mediums) {
        JpaUtil.log("ClientDaoJpa : choisirMediums");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            
            //Lier une liste de mediums a un client
            unClient.addMediums(mediums);
            em.merge(unClient);
            
        } catch (Exception ex) {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimerClient(Client unClient) {
        JpaUtil.log("ClientDaoJpa : supprimerClient");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();

            em.remove(unClient);
            
        } catch (Exception ex) {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public Client trouverClientAvecNomEtPrenom(String nom, String prenom) {
        JpaUtil.log("ClientDaoJpa : trouverClientAvecNom");
        try {
            Query query= JpaUtil.obtenirEntityManager().createQuery(
                    "select e from Client e where e.nom = :nom and e.prenom = :prenom");
            query.setParameter("nom", nom);
            query.setParameter("prenom", prenom);
            List<Client> result = (List<Client>)query.getResultList();
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
    
    @Override
    public Client trouverClientAvecId(long idClient) {
        JpaUtil.log("ClientDaoJpa : trouverClientAvecId");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            return em.find(Client.class, idClient);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
