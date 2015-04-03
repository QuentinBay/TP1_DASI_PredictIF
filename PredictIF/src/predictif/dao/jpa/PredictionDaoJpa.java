
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
 * Classe Jpa de prédiction qui implémente les métodes de la couche DAO
 * @author Alexis Papin & Quentin Bayart
 */
public class PredictionDaoJpa implements PredictionDao
{
    /**
     * Créé une prédiction
     * @param unePrediction  une prédiction
     */
    @Override
    public void creerPrediction(Prediction unePrediction) {
        JpaUtil.log("PredictionDaoJpa : creerPrediction");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            em.persist(unePrediction);
            
        } catch (Exception ex) {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Renvoie la liste des prédictions triées par type
     * @return une liste de prédictions
     */
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
    public Prediction trouverPredictionAvecId(long id) {
        return null;
    }
    
}
