
package predictif.dao.jpa;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import predictif.dao.PredictionDao;
import predictif.dao.SigneAstrologiqueDao;
import predictif.metier.modele.Amour;
import predictif.metier.modele.Prediction;
import predictif.metier.modele.SigneAstrologique;

/**
 * Classe Jpa de prédiction amoureuse qui implémente les métodes de la couche DAO
 * @author Alexis Papin & Quentin Bayart
 */
public class AmourDaoJpa implements PredictionDao {

    /**
     * Créé une prédiction de type Amour
     * @param unePrediction  une prédiction
     */
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
        return null;
    }

    /**
     * Renvoie une prédiction en fonction d'un identifiant
     * @param id un identifiant
     * @return une prédiction
     */
    @Override
    public Prediction trouverPredictionAvecId(long id) {
        JpaUtil.log("ClientDaoJpa : trouverClientAvecId");
        try {
            EntityManager em = JpaUtil.obtenirEntityManager();
            return em.find(Prediction.class, id);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }}

}
