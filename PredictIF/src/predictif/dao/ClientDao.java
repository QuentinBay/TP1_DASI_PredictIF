/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.dao;
import predictif.metier.modele.Client;

/**
 * 
 * @author qbayart
 */
public interface ClientDao {
    public void creerClient(Client unClient);
    public Client miseAJourClient(Client unClient);
    public void supprimerClient(Client unClient);
    public Client trouverClientAvecNom(String unNom);
}
