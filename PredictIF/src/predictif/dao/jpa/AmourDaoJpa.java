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
import predictif.dao.AmourDao;
import predictif.dao.PredictionDao;
import predictif.dao.SigneAstrologiqueDao;
import predictif.metier.modele.Amour;
import predictif.metier.modele.Prediction;
import predictif.metier.modele.SigneAstrologique;

/**
 *
 * @author quentin
 */
public class AmourDaoJpa implements PredictionDao {


    @Override
    public void creerPrediction(Prediction unePrediction) {
        JpaUtil.log("AmourDaoJpa : creerPredictionAmour");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            Amour amour = (Amour)unePrediction;
            em.persist(amour);
            
            //Lier un signe astrologique a un client
            SigneAstrologiqueDao monGESigne = new SigneAstrologiqueDaoJpa();
            int moisPartenaire = (int)(Math.random()*11);
            System.out.println("mois du partenaire : "+moisPartenaire);
            SigneAstrologique signe = monGESigne.trouverSigneAstrologiqueAvecMois(moisPartenaire);
            amour.setPartenaire(signe);
            em.merge(amour);
            
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
