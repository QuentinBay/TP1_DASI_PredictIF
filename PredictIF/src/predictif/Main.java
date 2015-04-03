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
import predictif.util.SimulationEnvoyeurMail;
/**
 *
 * @author qbayart
 */
public class Main 
{
    public static void main (String[] args)
    {
        Service service = new Service();
        //service.initialiser();
        
       /* Client c1 = new Client( 'm',  "Bayarto","Quentin", new Date(93, 10, 10), 
                                "123 rue", "060555555", "Quentin@hotmail.fr");
        service.ajouterClient(c1);
        service.affecterClientAEmploye(c1);
        //System.out.println();
        service.envoiMailClient(c1, new SimulationEnvoyeurMail());
        
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
        
        System.out.println("# Session interactive");*/
        
                            /****************************
                            /  SERVICES POUR IHM CLIENT  /
                            *****************************/        
        
        /*System.out.println("## Inscription client");
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
        displayData(subToString(service.listerMediums().toArray()));
        String meStr = Saisie.lireChaine("Numero des mediums (separes par une virgule) : ");
        List<Medium> mediumsFavoris = new Vector<Medium>();
        MediumDao monGEMedium = new MediumDaoJpa();
        for(String mIdStr : meStr.split(",")) {
            int mId = Integer.parseInt(mIdStr);
            mediumsFavoris.add(service.trouverMediumAvecId(mId));
        }
        System.out.println();

        service.choisirMediums(c1, mediumsFavoris);
        System.out.println("Mediums choisis : ");
        displayData(subToString(c1.getMediums().toArray()));
        
        
        service.affecterClientAEmploye(c1);
        System.out.println("INFORMATION : Le client a été ajouté à l'employé qui en a le moins.");
        
        System.out.println("Envoi d'un mail au client");
        service.envoiMailClient(c1, new SimulationEnvoyeurMail());
        System.out.println();*/
        
                           /******************************
                           /  SERVICES POUR IHM EMPLOYE   /
                           *******************************/
        
        System.out.println("##Création d'un horoscope");
        System.out.println("###Connection d'un employé");
        displayData(subToString(service.listerEmployes().toArray()));
        String login = Saisie.lireChaine(" - Login : ");
        String mdp = Saisie.lireChaine(" - Mot de passe : ");
        Employe e = service.trouverEmployeAvecPseudoEtMDP(login, mdp);
        System.out.println(e);
        
        System.out.println("###Choix d'un client");
        displayData(subToString(service.listerClients(e).toArray()));
        int clientId = Saisie.lireInteger(" - Numero du client : ");
        Client client = service.trouverClientAvecId(clientId);
        System.out.println();
        
        System.out.println("###Choix d'un medium");
        displayData(subToString(service.listerMediumsClient(client).toArray()));
        int mediumId = Saisie.lireInteger(" - Numero du medium : ");
        Medium medium = service.trouverMediumAvecId(mediumId);
        System.out.println();
        
    }
    
    private static String[] subToString(Object[] objects) {
        String[] strings = new String[objects.length];
        for (int i = 0; i < objects.length; i ++) {
            strings[i] = objects[i].toString();
        }
        return strings;
    }
    
    private static void displayData(String[] textes)
    {
        for (String texte : textes) {
            System.out.print(" * ");
            System.out.println(texte);
        }
        System.out.println("");
    }
    
}
