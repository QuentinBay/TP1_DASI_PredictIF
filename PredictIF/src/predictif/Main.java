/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif;

import predictif.metier.service.Service;
import predictif.dao.jpa.JpaUtil;
import predictif.dao.ClientDao;
import predictif.dao.jpa.ClientDaoJpa;
import predictif.dao.EmployeDao;
import predictif.dao.jpa.SigneAstrologiqueDaoJpa;
import predictif.dao.SigneAstrologiqueDao;
import predictif.dao.jpa.EmployeDaoJpa;

import predictif.metier.modele.Client;
import predictif.metier.modele.Employe;
import predictif.metier.modele.Medium;

import java.util.Date;
import java.util.List;
import java.util.Iterator;
/**
 *
 * @author qbayart
 */
public class Main 
{
    public static void main (String[] args)
    {
        //Date d = new Date(15,2,1);
        //System.out.println("Jour : "+d.getDay()+" Mois : "+d.getMonth()+" Année : "+d.getYear());
        Service service = new Service();
        //service.initialiser();
        Employe e = service.trouverEmployeAvecPseudoEtMDP("Bubu", "mdp");
        //ATTENTION : Si on ne trouve pas l employe
        if (e!=null)
        {
            System.out.println(e.getPrenom()+" "+e.getNom());
        }
        else
        {
            System.out.println("Employe not found !");
        }
        List<Medium> mediums = (List<Medium>)service.listerMediums();
        System.out.println("Nb de mediums : "+mediums.size());
        Iterator it = mediums.iterator();
        
        while(it.hasNext())
        {
            
            System.out.println(it.next().toString());
        }
       /* Client c1 = new Client( 'm', "Quentin", "Bayart", new Date(10, 10, 15), 
                                "123 rue", "060555555", apin@hotmail.fr");
        service.ajouterClient(c1);
       JpaUtil.init();
       JpaUtil.creerEntityManager();
       JpaUtil.ouvrirTransaction();
       
       SigneAstrologiqueDao monGEAstro = new SigneAstrologiqueDaoJpa();
       monGEAstro.creerTousLesSignesAstrologiques();
       
       
       ClientDao monGestionnaireEntites = new ClientDaoJpa();
       monGestionnaireEntites.creerClient(c1);
       
       Employe e1 = new Employe ( "Emp1", "mdp", "Bubu", "Tomtom");
       EmployeDao monGestionnaireEntitesEmploye = new EmployeDaoJpa();
       monGestionnaireEntitesEmploye.creerEmploye(e1);
       
       e1.addClient(c1);
       
       JpaUtil.validerTransaction();
       JpaUtil.fermerEntityManager();*/
    }
    
}
