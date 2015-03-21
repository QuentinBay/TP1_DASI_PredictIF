/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.dao.jpa;

import predictif.dao.ClientDao;
import predictif.metier.modele.Client;
import javax.persistence.EntityManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author qbayart
 */
public class ClientDaoJpa implements ClientDao {

    /* --------------------------------------- CONSTRUCTEURS --------------------------------------- */
    
    public ClientDaoJpa() {}
    
    /* ----------------------------------------- METHODES ------------------------------------------ */

    @Override
    public void creerClient(Client unClient) {
        JpaUtil.log("debut transaction");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            em.persist(unClient);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
