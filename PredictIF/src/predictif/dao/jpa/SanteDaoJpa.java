
package predictif.dao.jpa;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import predictif.dao.PredictionDao;
import predictif.metier.modele.Prediction;
import predictif.metier.modele.Sante;

/**
 * Classe Jpa de prédiction santé qui implémente les métodes de la couche DAO
 * @author Alexis Papin & Quentin Bayart
 */
public class SanteDaoJpa implements PredictionDao {

    /**
     * Créé une prédiction de type santé
     * @param unePrediction  une prédiction
     */
    @Override
    public void creerPrediction(Prediction unePrediction) {
        JpaUtil.log("TravailDaoJpa : creerPredictionTravail");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            Sante sante=(Sante)unePrediction;
            em.persist(sante);
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
        JpaUtil.log("SanteDaoJpa : trouverPredictionAvecId");
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
