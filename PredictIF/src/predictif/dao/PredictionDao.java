
package predictif.dao;

import predictif.metier.modele.Prediction;
import java.util.List;
/**
 * Interface DAO des prédictions
 * @author Alexis Papin & Quentin Bayart
 */
public interface PredictionDao 
{
    /**
     * Créé une prédiction
     * @param unePrediction  une prédiction
     */
    public void creerPrediction(Prediction unePrediction);
    
    /**
     * Renvoie la liste des prédictions triées par type
     * @return une liste de prédictions
     */
    public List<Prediction> trierPredictionAvecType();
    
    /**
     * Renvoie une prédiction en fonction d'un identifiant
     * @param id un identifiant
     * @return une prédiction
     */
    public Prediction trouverPredictionAvecId(long id);
}
