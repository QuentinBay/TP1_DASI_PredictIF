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
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

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
        JpaUtil.log("debut transaction : ClientDao");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            em.persist(unClient);
            
            //Lier un signe astrologique a un client
            SigneAstrologiqueDao monGESigne = new SigneAstrologiqueDaoJpa();
            int moisClient = unClient.getDateNaissance().getMonth();
            SigneAstrologique signe = monGESigne.trouverSigneAstrologiqueAvecMois(moisClient);
            unClient.setSigne(signe);
            //em.persist(unClient);
            
        } catch (Exception ex) {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Client miseAJourClient(Client unClient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerClient(Client unClient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client trouverClientAvecNom(String unNom) {
        Query query= JpaUtil.obtenirEntityManager().createQuery(
                "select c from Client c where c.nom=:clientNom ");
        
        query.setParameter("clientNom", unNom);
        //query.setParameter("empMotDePasse", unMdp);
        List<Client> result = (List<Client>)query.getResultList();
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
}
