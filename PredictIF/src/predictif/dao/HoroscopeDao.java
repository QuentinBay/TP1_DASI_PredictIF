
package predictif.dao;

import predictif.metier.modele.Horoscope;
import predictif.metier.modele.Prediction;
import java.util.List;
import predictif.metier.modele.Amour;
import predictif.metier.modele.Client;
import predictif.metier.modele.Medium;
import predictif.metier.modele.Sante;
import predictif.metier.modele.Travail;
/**
 * Interface DAO de l'horoscope 
 * @author Alexis Papin & Quentin Bayart
 */
public interface HoroscopeDao 
{
    /**
     * Créé un horoscope 
     * @param horoscope un horoscope
     * @param client un client
     * @param medium un médium
     * @return un horoscope
     */
    public Horoscope creerHoroscope(Horoscope horoscope, Client client, Medium medium);
    
    /**
     * Créé un horoscope 
     * @param horoscope un horoscope
     * @param client un client
     * @param medium un médium
     * @param predAmour une prédiction d'amour
     * @param predSante une prédiction de santé
     * @param predTravail une prédiction de travail
     * @return un horoscope
     */
    public Horoscope creerHoroscope(Horoscope horoscope, Client client, Medium medium, Prediction predAmour, Prediction predSante, Prediction predTravail);
    
    /**
     * Renvoie un horoscope en fonction d'un identifiant
     * @param id un identifiant
     * @return un horoscope
     */
    public Horoscope trouverHoroscopeAvecId(long id);
    
    /**
     * Supprime une prédiction d'un horoscope
     * @param horoscope un horoscope
     * @param unePredictionune prédiction
     * @return un horoscope
     */
    public Horoscope supprimerPrediction(Horoscope horoscope, Prediction unePrediction);
    
    /**
     * Ajoute une prédiction à une horoscope
     * @param horoscope un horoscope
     * @param unePrediction une prédiction
     * @return un horoscope
     */
    public Horoscope ajouterPrediction(Horoscope horoscope, Prediction unePrediction);
    
    /**
     * Renvoie l'historique des horoscopes d'un client
     * @param client un client
     * @return la liste des horoscopes
     */
    public List<Horoscope> trouverTousLesHoroscopes(Client client);
}
