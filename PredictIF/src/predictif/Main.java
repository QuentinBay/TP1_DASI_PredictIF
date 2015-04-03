/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import predictif.util.Saisie;

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
import java.util.Vector;
import java.util.Iterator;
import predictif.dao.MediumDao;
import predictif.dao.jpa.MediumDaoJpa;
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
        //Medium m = service.trouverMediumAvecId(23);
        //System.out.println(m);
        //service.initialiser();
        /*Employe e = service.trouverEmployeAvecPseudoEtMDP("Bubu", "mdp");
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
        }*/
        
        System.out.println("# Session interactive");
        System.out.println("## Inscription client");
        System.out.println("### Informations de base");
        String civilite = Saisie.lireChaine(" - Civilite : ");
        String nom = Saisie.lireChaine(" - Nom : ");
        String prenom = Saisie.lireChaine(" - Prenom : ");
        String dnStr = Saisie.lireChaine(" - Date de Naissance : ");

        Date dateNaissance = null;
        try {
            dateNaissance = new SimpleDateFormat("dd/MM/yyyy").parse(dnStr);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        String adresse = Saisie.lireChaine(" - Adresse : ");
        String telephone = Saisie.lireChaine(" - Telephone : ");
        String email = Saisie.lireChaine(" - Email : ");
        System.out.println();
        Client c1 = new Client(civilite.charAt(0), nom, prenom, dateNaissance, adresse, telephone, email);
        service.ajouterClient(c1);
        
        System.out.println("### Choix des mediums favoris");
        String meStr = Saisie.lireChaine("      Numero des mediums (separes par une virgule) : ");
        List<Medium> mediumsFavoris = new Vector<Medium>();
        MediumDao monGEMedium = new MediumDaoJpa();
        for(String mIdStr : meStr.split(",")) {
            int mId = Integer.parseInt(mIdStr);
            mediumsFavoris.add(service.trouverMediumAvecId(mId));
        }
        System.out.println();

        service.choisirMediums(c1, mediumsFavoris);
    }
    
}
