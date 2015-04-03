/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.dao.jpa;

import predictif.dao.PredictionDao;
import predictif.metier.modele.Prediction;
import javax.persistence.EntityManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.Vector;
import javax.persistence.Query;
import predictif.metier.modele.Employe;

/**
 *
 * @author quentin
 */
public class PredictionDaoJpa implements PredictionDao
{

    @Override
    public void creerPrediction(Prediction unePrediction) {
        JpaUtil.log("debut transaction : Creer Prediction");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            em.persist(unePrediction);
            
        } catch (Exception ex) {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Prediction> trierPredictionAvecType() {
        JpaUtil.log("PredictionDaoJpa : trierPredictionAvecType");
        try {
            Query query= JpaUtil.obtenirEntityManager().createQuery("select p from Prediction p order by p.type");

            List<Prediction> result = (List<Prediction>)query.getResultList();
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

    @Override
    public List<Prediction> trouverToutesPredictions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
