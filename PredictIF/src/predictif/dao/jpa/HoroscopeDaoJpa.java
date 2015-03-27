/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.dao.jpa;

import predictif.dao.HoroscopeDao;
import predictif.metier.modele.Horoscope;
import javax.persistence.EntityManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.Vector;
import predictif.metier.modele.Prediction;
/**
 *
 * @author quentin
 */
public class HoroscopeDaoJpa implements HoroscopeDao {

    @Override
    public void creerHoroscope(Horoscope unHoroscope) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Horoscope miseAJourHoroscope(Horoscope unHoroscope) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerHoroscope(Horoscope unHoroscope) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouterPrediction(Prediction unePrediction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Horoscope> trouverToutesHoroscopes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
