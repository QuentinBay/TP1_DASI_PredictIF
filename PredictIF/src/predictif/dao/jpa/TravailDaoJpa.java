/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.dao.jpa;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import predictif.dao.PredictionDao;
import predictif.metier.modele.Prediction;
import predictif.metier.modele.Travail;

/**
 *
 * @author quentin
 */
public class TravailDaoJpa implements PredictionDao{

    @Override
    public void creerPrediction(Prediction unePrediction) {
        JpaUtil.log("TravailDaoJpa : creerPredictionTravail");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            Travail travail=(Travail)unePrediction;
            em.persist(travail);
        } catch (Exception ex) {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Prediction> trierPredictionAvecType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Prediction> trouverToutesPredictions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
