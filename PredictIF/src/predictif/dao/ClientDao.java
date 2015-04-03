
package predictif.dao;
import predictif.metier.modele.Client;
import predictif.metier.modele.Medium;

import java.util.List;
import predictif.metier.modele.Employe;

/**
 * Interface DAO de client
 * @author Alexis Papin & Quentin Bayart
 */
public interface ClientDao {
    /**
     * Créé un client
     * @param unClient un client
     */
    public void creerClient(Client unClient);
    
    /**
     * Met à jour la liste des médiums d'un client
     * @param unClient un client
     * @param mediums des médiums
     */
    public void choisirMediums(Client unClient, List<Medium> mediums);
    

    
    /**
     * Renvoie un client à partir de son nom et prénom
     * @param nom un nom
     * @param prenom un prénom
     * @return un client
     */
    public Client trouverClientAvecNomEtPrenom(String nom, String prenom);
    
    /**
     * Renvoie un client à partir de son identifiant
     * @param idClient un identifiant
     * @return un client
     */
    public Client trouverClientAvecId(long idClient);
    
    /**
     * Renvoie la liste des clients d'un employé
     * @param employe un employé
     * @return une liste de clients
     */
    public List<Client> classesPourChoixEmploye(Employe employe);
    
    /**
     * Renvoie la liste des médiums favoris d'un client
     * @param client un client
     * @return une liste
     */
    public List<Medium> listerMediumsFavoris(Client client);
}
