/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.dao;

import predictif.metier.modele.Employe;
import predictif.metier.modele.Client;
/**
 *
 * @author qbayart
 */
public interface EmployeDao {
    public void creerEmploye(Employe unEmploye);
    public Employe miseAJourEmploye(Employe unEmploye);
    public void supprimerEmploye(Employe unEmploye);
    public Employe trouverEmployeAvecPseudoEtMdp(String unPseudo, String unMdp);
    //public void addClient (Client unClient);
    //public void removeClient (Client unClient);
}
