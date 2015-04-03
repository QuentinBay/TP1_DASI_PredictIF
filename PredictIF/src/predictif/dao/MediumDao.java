/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.dao;

import predictif.metier.modele.Medium;
import java.util.List;
/**
 *
 * @author qbayart
 */
public interface MediumDao {
    public void creerMedium(Medium unMedium);
    public Medium miseAJourMedium(Medium unMedium);
    public void supprimerMedium(Medium unMedium);
    public Medium trouverMediumAvecPseudo(String unPseudo);
    public Medium trouverMediumAvecID(long unID);
    public List<Medium> trouverTousMediums();
    
}
