
package predictif.dao.jpa;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import predictif.dao.PredictionDao;
import predictif.metier.modele.Prediction;
import predictif.metier.modele.Travail;

/**
 * Classe Jpa de prédiction travail qui implémente les métodes de la couche DAO
 * @author Alexis Papin & Quentin Bayart
 */
public class TravailDaoJpa implements PredictionDao{
    
    /**
     * Créé une prédiction de type travail
     * @param unePrediction  une prédiction
     */
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
        return null;
    }

    /**
     * Renvoie une prédiction en fonction d'un identifiant
     * @param id un identifiant
     * @return une prédiction
     */
    @Override
    public Prediction trouverPredictionAvecId(long id) {
        JpaUtil.log("TravailDaoJpa : trouverPredictionAvecId");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            return em.find(Prediction.class, id);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
