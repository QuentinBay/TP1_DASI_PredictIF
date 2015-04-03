
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
import predictif.metier.modele.Amour;
import predictif.metier.modele.Horoscope;
import predictif.metier.modele.Prediction;
import predictif.metier.modele.Sante;
import predictif.metier.modele.Travail;
import predictif.util.SimulationEnvoyeurMail;
/**
 * Classe principale
 * @author Alexis Papin & Quentin Bayart
 */
public class Main 
{
    public static void main (String[] args)
    {
        Service service = new Service();
        
        
                            /****************************
                            /  SERVICES POUR IHM CLIENT  /
                            *****************************/        
        
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
        System.out.println("");
        service.envoiMailClient(c1, new SimulationEnvoyeurMail());
        System.out.println();
        
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
        
        System.out.println("###Historique des horoscopes");
        displayData(subToString(service.listerHistoriqueClient(client).toArray()));
        System.out.println();
        
        System.out.println("###Choix d'un medium");
        displayData(subToString(service.listerMediumsClient(client).toArray()));
        int mediumId = Saisie.lireInteger(" - Numero du medium : ");
        Medium medium = service.trouverMediumAvecId(mediumId);
        System.out.println();
        
        Horoscope horoscope = new Horoscope(new Date(15,04,03));
        horoscope= service.creerHoroscope(horoscope, client, medium);
        
        System.out.println("Choix Prediction Travail");
        displayData(subToString(service.listerPredictionsTriees().toArray()));
        int pAmId = Saisie.lireInteger(" -  Numero de la prediction amour : ");
        Prediction pAm = service.trouverPredictionAmourAvecId(pAmId);
        horoscope= service.ajouterPrediction(horoscope, pAm);
        System.out.println("Horoscope en cours :");
        System.out.println(horoscope);
        
        int pStId = Saisie.lireInteger(" -  Numero de la prediction sante : ");
        Prediction pSt = service.trouverPredictionSanteAvecId(pStId);
        horoscope= service.ajouterPrediction(horoscope, pSt);
        System.out.println("Horoscope en cours :");
        System.out.println(horoscope);
        
        int pTrId = Saisie.lireInteger(" -  Numero de la prediction travail : ");
        Prediction pTr = service.trouverPredictionTravailAvecId(pTrId);
        System.out.println();
        System.out.println(horoscope);
        horoscope= service.ajouterPrediction(horoscope, pTr);
        System.out.println("Horoscope en cours :");
        System.out.println(horoscope);
        
        int pSupprId = Saisie.lireInteger(" -  Numero de la prediction à supprimer : ");
        Prediction pSuppr = service.trouverPredictionTravailAvecId(pSupprId);
        System.out.println();
        System.out.println(horoscope);
        horoscope= service.supprimerPrediction(horoscope, pSuppr);
        System.out.println("Horoscope en cours :");
        System.out.println(horoscope);
        
        int pAjId = Saisie.lireInteger(" -  Numero de la prediction à rajouter : ");
        Prediction pAj = service.trouverPredictionTravailAvecId(pAjId);
        System.out.println();
        System.out.println(horoscope);
        horoscope= service.ajouterPrediction(horoscope, pAj);
        System.out.println("Horoscope en cours :");
        System.out.println(horoscope);
        
        System.out.println("Envoi de l'horoscope au client");
        System.out.println("");
        service.envoiHoroscopeClient(horoscope, new SimulationEnvoyeurMail());
        System.out.println("");
        System.out.println("Fin de la simulation");
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
