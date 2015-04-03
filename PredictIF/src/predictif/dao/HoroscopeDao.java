/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author quentin
 */
public interface HoroscopeDao 
{
    public Horoscope creerHoroscope(Horoscope horoscope, Client client, Medium medium, Prediction predAmour, Prediction predSante, Prediction predTravail);
    public Horoscope trouverHoroscopeAvecId(long id);
    //public void supprimerHoroscope(Horoscope unHoroscope);
    public void ajouterPrediction(Prediction unePrediction);
    public List<Horoscope> trouverTousLesHoroscopes(Client client);
}
