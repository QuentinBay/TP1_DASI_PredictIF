/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author quentin
 */
public class HoroscopeDaoJpa implements HoroscopeDao {

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


    @Override
    public void ajouterPrediction(Prediction unePrediction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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


    
}
