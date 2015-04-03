/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.dao;
import predictif.metier.modele.Client;
import predictif.metier.modele.Medium;

import java.util.List;

/**
 * 
 * @author qbayart
 */
public interface ClientDao {
    public void creerClient(Client unClient);
    public void choisirMediums(Client unClient, List<Medium> mediums);
    public void supprimerClient(Client unClient);
    public Client trouverClientAvecNomEtPrenom(String nom, String prenom);
    public Client trouverClientAvecId(long idClient);
}
