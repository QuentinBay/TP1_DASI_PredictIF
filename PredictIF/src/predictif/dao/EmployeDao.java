
package predictif.dao;

import java.util.List;
import predictif.metier.modele.Employe;
import predictif.metier.modele.Client;
/**
 * Interface DAO d'employé
 * @author Alexis Papin & Quentin Bayart
 */
public interface EmployeDao {
    /**
     * Créé un émployé
     * @param unEmploye un employé
     */
    public void creerEmploye(Employe unEmploye);
    
    /**
     * Renvoie un employé à partir d'un pseudo et d'un mot de passe
     * @param unPseudo un pseudo
     * @param unMdp un mot de passe
     * @return un employé
     */
    public Employe trouverEmployeAvecPseudoEtMdp(String unPseudo, String unMdp);
    
    /**
     * Trouve l employe qui a le moins de clients
     * @return l employe
     */
    public Employe moinsDeClients();
    
    /**
     * Ajoute un client à un employé
     * @param emp un employé
     * @param unClient un client
     */
    public void ajouterClient (Employe emp,Client unClient);
    
    /**
     * Renvoie une liste de tous les employés de Predictif
     * @return une liste d'employés
     */
    public List<Employe> listerEmployes ();
}
