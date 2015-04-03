
package predictif.dao;

import predictif.metier.modele.Medium;
import java.util.List;
/**
 * Interface DAO de Medium
 * @author Alexis Papin & Quentin Bayart
 */
public interface MediumDao {
    /**
     * Créé un médium
     * @param unMedium un médium
     */
    public void creerMedium(Medium unMedium);
    
    /**
     * Renvoie un médium à partir d'un identifiant
     * @param unID un identifiant
     * @return un médium
     */
    public Medium trouverMediumAvecID(long unID);
    
    /**
     * Renvoie la liste de tous les médiums
     * @return une liste de médiums
     */
    public List<Medium> trouverTousMediums();
    
}
