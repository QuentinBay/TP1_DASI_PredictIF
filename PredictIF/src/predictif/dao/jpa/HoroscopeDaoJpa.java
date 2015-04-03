
package predictif.dao.jpa;

import predictif.dao.HoroscopeDao;
import predictif.metier.modele.Horoscope;
import javax.persistence.EntityManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.Vector;
import javax.persistence.Query;
import predictif.metier.modele.Amour;
import predictif.metier.modele.Client;
import predictif.metier.modele.Medium;
import predictif.metier.modele.Prediction;
import predictif.metier.modele.Sante;
import predictif.metier.modele.Travail;
/**
 * Classe Horoscope qui implémente les méthodes de la couche Dao
 * @author Alexis Papin & Quentin Bayart
 */
public class HoroscopeDaoJpa implements HoroscopeDao {

    /**
     * Créé un horoscope 
     * @param horoscope un horoscope
     * @param client un client
     * @param medium un médium
     * @param predAmour une prédiction d'amour
     * @param predSante une prédiction de santé
     * @param predTravail une prédiction de travail
     * @return un horoscope
     */
    @Override
    public Horoscope creerHoroscope(Horoscope horoscope, Client client , Medium medium ,Prediction predAmour, Prediction predSante, Prediction predTravail) {
        JpaUtil.log("HoroscopeDaoJpa : creerHoroscope");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            em.persist(horoscope);
            
            //Ajoutons les predictions selectionnees a l horoscope
            List<Prediction> predictions= new Vector<Prediction>();
            predictions.add(predAmour);
            predictions.add(predSante);
            predictions.add(predTravail);
            horoscope.setPredictions(predictions);
            
            //Associe un client a l horoscope
            horoscope.setClient(client);
            
            //Associe un medium a la prediction
            horoscope.setMedium(medium);
            em.merge(horoscope);
            return horoscope;
            
        } catch (Exception ex) {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Renvoie un horoscope en fonction d'un identifiant
     * @param id un identifiant
     * @return un horoscope
     */
    @Override
    public Horoscope trouverHoroscopeAvecId(long id) {
        JpaUtil.log("HoroscopeDaoJpa : trouverHoroscopeAvecId");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            return em.find(Horoscope.class, id);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }

    /**
     * Ajoute une prédiction à une horoscope
     * @param horoscope un horoscope
     * @param unePrediction une prédiction
     * @return un horoscope
     */
    @Override
    public Horoscope ajouterPrediction(Horoscope horoscope, Prediction unePrediction) {
        JpaUtil.log("HoroscopeDaoJpa : ajouterPrediction");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            //Associe un client a l horoscope
            horoscope.ajouterPrediction(unePrediction);
            em.merge(horoscope);
            
            return horoscope;
            
        } catch (Exception ex) {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * Supprime une prédiction d'un horoscope
     * @param horoscope un horoscope
     * @param unePredictionune prédiction
     * @return un horoscope
     */
    @Override
    public Horoscope supprimerPrediction(Horoscope horoscope, Prediction unePrediction) {
        JpaUtil.log("HoroscopeDaoJpa : ajouterPrediction");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            //Associe un client a l horoscope
            horoscope.supprimerPrediction(unePrediction);
            em.merge(horoscope);
            
            return horoscope;
            
        } catch (Exception ex) {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Renvoie l'historique des horoscopes d'un client
     * @param client un client
     * @return la liste des horoscopes
     */
    @Override
    public List<Horoscope> trouverTousLesHoroscopes(Client client) {
        JpaUtil.log("HoroscopeDaoJpa : trouverTousLesHoroscopes");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            Query q = em.createQuery("select c.horoscopes from Client c where c.numClient = :unID");
            q.setParameter("unID", client.getNumClient());
            return (List<Horoscope>) q.getResultList();
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }

    /**
     * Créé un horoscope 
     * @param horoscope un horoscope
     * @param client un client
     * @param medium un médium
     * @return un horoscope
     */
    @Override
    public Horoscope creerHoroscope(Horoscope horoscope, Client client, Medium medium) {
        JpaUtil.log("HoroscopeDaoJpa : creerHoroscope");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            em.persist(horoscope);

            
            //Associe un client a l horoscope
            horoscope.setClient(client);
            
            //Associe un medium a la prediction
            horoscope.setMedium(medium);
            em.merge(horoscope);
            return horoscope;
            
        } catch (Exception ex) {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    
}
