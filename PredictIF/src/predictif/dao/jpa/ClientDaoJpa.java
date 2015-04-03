
package predictif.dao.jpa;

import predictif.dao.ClientDao;
import predictif.dao.SigneAstrologiqueDao;
import predictif.metier.modele.Client;
import predictif.metier.modele.SigneAstrologique;
import javax.persistence.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import predictif.metier.modele.Employe;
import predictif.metier.modele.Medium;

/**
 * Classe jpa de client implémentant les méthodes de l'interface DAO
 * @author Alexis Papin & Quentin Bayart
 */
public class ClientDaoJpa implements ClientDao {

    /* --------------------- CONSTRUCTEURS ---------------------------------- */
    /**
     * Constructeur par défaut
     */
    public ClientDaoJpa() {}
    
    /* ------------------------ METHODES ------------------------------------ */

    /**
     * Créé un client
     * @param unClient un client
     */
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

    /**
     * Met à jour la liste des médiums d'un client
     * @param unClient un client
     * @param mediums des médiums
     */
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
    
    /**
     * Retrouve un client par son nom et son prenom
     * @param nom Son nom
     * @param prenom Son prenom
     * @return Le client
     */
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
    
    /**
     * Renvoie un client à partir de son identifiant
     * @param idClient un identifiant
     * @return un client
     */
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
    
    /**
     * Renvoie la liste des clients d'un employé
     * @param employe un employé
     * @return une liste de clients
     */
    public List<Client> classesPourChoixEmploye(Employe employe) {
        JpaUtil.log("ClientDaoJpa : classesPourEmploye");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            Query q = em.createQuery("select e.clients from Employe e where e.id = :empId");
            q.setParameter("empId", employe.getId());
            return (List<Client>) q.getResultList();
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * Renvoie la liste des médiums favoris d'un client
     * @param client un client
     * @return une liste
     */
    @Override
    public List<Medium> listerMediumsFavoris(Client client)
    {
        JpaUtil.log("ClientDaoJpa : listerMediumsFavoris");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            Query q = em.createQuery("select c.mediums from Client c where c.numClient = :unID");
            q.setParameter("unID", client.getNumClient());
            return (List<Medium>) q.getResultList();
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
