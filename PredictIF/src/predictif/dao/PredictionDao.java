/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.dao;

import predictif.metier.modele.Prediction;
import java.util.List;
/**
 *
 * @author quentin
 */
public interface PredictionDao 
{
    public void creerPrediction(Prediction unePrediction);
    public List<Prediction> trierPredictionAvecType();
    public Prediction trouverPredictionAvecId(long id);
}
