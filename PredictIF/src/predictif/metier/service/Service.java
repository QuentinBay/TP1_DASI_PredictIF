/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.metier.service;

import java.text.SimpleDateFormat;
import predictif.dao.jpa.JpaUtil;

import predictif.dao.ClientDao;
import predictif.dao.jpa.ClientDaoJpa;
import predictif.metier.modele.Client;

import predictif.dao.EmployeDao;
import predictif.dao.jpa.EmployeDaoJpa;
import predictif.metier.modele.Employe;

import predictif.dao.SigneAstrologiqueDao;
import predictif.dao.jpa.SigneAstrologiqueDaoJpa;
import predictif.metier.modele.SigneAstrologique;

import predictif.dao.MediumDao;
import predictif.dao.jpa.MediumDaoJpa;
import predictif.metier.modele.Medium;

import predictif.dao.EmployeDao;
import predictif.dao.jpa.EmployeDaoJpa;
import predictif.metier.modele.Employe;

import predictif.dao.PredictionDao;
import predictif.dao.jpa.PredictionDaoJpa;
import predictif.metier.modele.Prediction;

import predictif.dao.HoroscopeDao;
import predictif.dao.jpa.HoroscopeDaoJpa;
import predictif.metier.modele.Horoscope;

import java.util.Date; // AA/MM/JJ
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import predictif.dao.jpa.AmourDaoJpa;
import predictif.dao.jpa.SanteDaoJpa;
import predictif.dao.jpa.TravailDaoJpa;
import predictif.metier.modele.Amour;
import predictif.metier.modele.Sante;
import predictif.metier.modele.Travail;
/**
 *
 * @author qbayart
 */
public class Service 
{
/*------------------------------------ATTRIBUTS-----------------------------------*/
    private static String ADRESSE_EXPEDITEUR = "Jean-Charles@predictif.com";
    
/*----------------------------------CONSTRUCTEURS---------------------------------*/
    public Service () { }
/*-------------------------------------METHODES-----------------------------------*/
    public void initialiser()
    // On cree pleins de clients, employes.. pour la demo
    {
        JpaUtil.log("Service : initialiser");
        try 
        {
            JpaUtil.init();
            JpaUtil.creerEntityManager();

            try 
            {
                JpaUtil.ouvrirTransaction();
/*----------------------------CREATION SIGNES ASTROLOGIQUES-----------------------*/
                SigneAstrologiqueDao monGESigneAstrologique = new SigneAstrologiqueDaoJpa();
                monGESigneAstrologique.creerTousLesSignesAstrologiques();
                
                
                
/*-------------------------------CREATION MEDIUMS---------------------------------*/
                MediumDao monGEMedium = new MediumDaoJpa();
                Medium m1 = new Medium("Madame Irma","Voyante reconnue","photo");
                Medium m2 = new Medium("Madame du Soleil","Voyante reconnue","photo");
                Medium m3 = new Medium("Marabou","Voyant reconnu","photo");
                Medium m4 = new Medium("Monsieur Tarot","Voyant reconnu","photo");
                Medium m5 = new Medium("Claire Voyance","Voyante reconnue","photo");
                Medium m6 = new Medium("Mademoiselle future","Voyante reconnue","photo");
                Medium m7 = new Medium("Paul Lepoulpe","Voyant reconnu","photo");
                Medium m8 = new Medium("Charles Atant","Voyant reconnu","photo");
                Medium m9 = new Medium("Jean Caisse","Voyant reconnu","photo");
                Medium m10 = new Medium("Dieu","Voyant reconnu","photo");
                Medium m11 = new Medium("Monsieur Voyant","Voyant reconnu","photo");
                Medium m12 = new Medium("Madame Voyante","Voyante reconnue","photo");
				
                monGEMedium.creerMedium(m1);
                monGEMedium.creerMedium(m2);
                monGEMedium.creerMedium(m3);
                monGEMedium.creerMedium(m4);
                monGEMedium.creerMedium(m5);
                monGEMedium.creerMedium(m6);
                monGEMedium.creerMedium(m7);
                monGEMedium.creerMedium(m8);
                monGEMedium.creerMedium(m9);
                monGEMedium.creerMedium(m10);
                monGEMedium.creerMedium(m11);
                monGEMedium.creerMedium(m12);
                
/*------------------------------CREATION EMPLOYES---------------------------------*/
                EmployeDao monGEEmploye = new EmployeDaoJpa();
                Employe e1 = new Employe ( "Bubu", "mdp", "Thomas", "Buffard");
                Employe e2 = new Employe ( "Chamcham", "0000", "Gael", "Champion");
                Employe e3 = new Employe ( "Gege", "1234", "Jorik", "Geiger");
                Employe e4 = new Employe ( "Digi", "9999", "Quentin", "Gillet");
                Employe e5 = new Employe ( "Guigui", "abcd", "Corentin", "Guignart");
                Employe e6 = new Employe ( "Schascha", "aaaa", "Valentin", "Schafer");
                Employe e7 = new Employe ( "Lulu", "password", "Morgan", "Lupion");
                Employe e8 = new Employe ( "Etieti", "monmdp", "Elyne", "Etienne");
                Employe e9 = new Employe ( "Dede", "azerty", "Adelaide", "Dearbe");
                Employe e10 = new Employe ( "Baba", "querty", "Laura", "Basset");
                Employe e11 = new Employe ( "bobo", "nbvcx", "Sarah", "Bordot");
                Employe e12 = new Employe ( "Mama", "poire", "Morgane", "Maillarbaux");
					
                monGEEmploye.creerEmploye(e1);
                monGEEmploye.creerEmploye(e2);
                monGEEmploye.creerEmploye(e3);
                monGEEmploye.creerEmploye(e4);
                monGEEmploye.creerEmploye(e5);
                monGEEmploye.creerEmploye(e6);
                monGEEmploye.creerEmploye(e7);
                monGEEmploye.creerEmploye(e8);
                monGEEmploye.creerEmploye(e9);
                monGEEmploye.creerEmploye(e10);
                monGEEmploye.creerEmploye(e11);
                monGEEmploye.creerEmploye(e12);
                
                
/*------------------------------CREATION PREDICTIONS------------------------------*/
                PredictionDao monGEPTravail = new TravailDaoJpa();
                PredictionDao monGEPAmour = new AmourDaoJpa();
                PredictionDao monGEPSante = new SanteDaoJpa();
                Prediction p1 = new Travail(1, 4, "Vous vous portez très bien aujourd'hui", 
                                                "image");
                Prediction p2 = new Sante(1, 1, "Ca ne va pas fort aujourd'hui", 
					"pluie", "Restez chez vous");
                Prediction p3 = new Travail(2, 2, "Une journée plutot commune", 
                        "ordinateur");
                Prediction p4 = new Amour(3, 4, "Une très bonne rencontre aujourd'hui", 
                        "coeur4");
                Prediction p5 = new Travail(2, 3, "Votre travail sera reconnu", 
                        "ordinateur");
                Prediction p6 = new Sante (1, 4, "Vous vous sentez libre comme l'air", 
                        "soleil", "Volez !");
                Prediction p7 = new Amour (3, 1, "Ca ne sent pas bon pour votre couple", 
                        "coeur1");
                Prediction p8 = new Sante (3, 2, "Une routine morose se fait sentir", 
                        "coeur2", "Changez d'air");
                Prediction p9 = new Sante (1, 1, "Votre tête vous fait mal", 
                        "pluie", "Prenez un doliprane");
                Prediction p10 = new Travail (2, 4, "Une promotion vous attend", 
                        "ordinateur");
                Prediction p11 = new Sante (1, 2, "Vous êtes un peu dans le brouillard", 
                        "nuageux", "Prenez un café");
                Prediction p12 = new Sante (3, 3, "Tout va pour le mieux, profitez-en", 
                        "coeur3", "Faites du sport");
												
                monGEPTravail.creerPrediction(p1);
                monGEPSante.creerPrediction(p2);
                monGEPTravail.creerPrediction(p3);
                monGEPAmour.creerPrediction(p4);
                monGEPTravail.creerPrediction(p5);
                monGEPSante.creerPrediction(p6);
                monGEPAmour.creerPrediction(p7);
                monGEPSante.creerPrediction(p8);
                monGEPSante.creerPrediction(p9);
                monGEPTravail.creerPrediction(p10);
                monGEPSante.creerPrediction(p11);
                monGEPSante.creerPrediction(p12);
                
/*--------------------------------CREATION CLIENTS--------------------------------*/
                ClientDao monGEClient = new ClientDaoJpa();
                Client c1 = new Client( 'm',  "Bayart","Quentin", new Date(93, 10, 10), 
                                "123 rue", "060555555", "Quentin@hotmail.fr");
                Client c2 = new Client( 'm', "Menella", "Adrien",  new Date(93, 8, 10), 
                                "123 rue", "060555555", "Adrien@hotmail.fr");
                Client c3 = new Client( 'm', "Mankai", "Skander",  new Date(95, 11, 10), 
                                "123 rue", "060555555", "Skander@hotmail.fr");
                Client c4 = new Client( 'm', "Bulme", "Kevin",  new Date(93, 1, 2), 
                                "123 rue", "060555555", "Kevin@hotmail.fr");
                Client c5 = new Client( 'm',"Papin", "Alexis",  new Date(94, 2, 12), 
                                "123 rue", "060555555", "papin@hotmail.fr");
                Client c6 = new Client( 'm', "Marin", "Leo", new Date(94, 1, 5), 
                                "123 rue", "060555555", "papin@hotmail.fr");
                Client c7 = new Client( 'm', "Bert", "Julie", new Date(94, 4, 8), 
                                "123 rue", "060555555", "papin@hotmail.fr");
                Client c8 = new Client( 'm', "Uhl", "Jean", new Date(94, 7, 9), 
                                "123 rue", "060555555", "papin@hotmail.fr");
                Client c9 = new Client( 'm', "Mer", "Charles", new Date(94, 10, 4), 
                                "123 rue", "060555555", "papin@hotmail.fr");
                Client c10 = new Client( 'm', "Kein", "Eric", new Date(94, 10, 2), 
                                "123 rue", "060555555", "papin@hotmail.fr");
                monGEClient.creerClient(c1);
                monGEClient.creerClient(c2);
                monGEClient.creerClient(c3);
                monGEClient.creerClient(c4);
                monGEClient.creerClient(c5);
                monGEClient.creerClient(c6);
                monGEClient.creerClient(c7);
                monGEClient.creerClient(c8);
                monGEClient.creerClient(c9);
                monGEClient.creerClient(c10);
                
                
/*------------------------------CREATION HOROSCOPES-------------------------------*/
                HoroscopeDao monGEHoroscope = new HoroscopeDaoJpa();
                Horoscope h1 = new Horoscope(new Date(10,4,15));
                Horoscope h2 = new Horoscope(new Date(2014,2,15));
                Horoscope h3 = new Horoscope(new Date(2014,3,20));
                Horoscope h4 = new Horoscope(new Date(2014,4,26));
                Horoscope h5 = new Horoscope(new Date(2015,1,5));
                Horoscope h6 = new Horoscope(new Date(2015,2,19));
                Horoscope h7 = new Horoscope(new Date(2015,3,5));
                Horoscope h8 = new Horoscope(new Date(2015,4,7));
                Horoscope h9 = new Horoscope(new Date(2015,5,14));
                Horoscope h10 = new Horoscope(new Date(2015,6,28));

                monGEHoroscope.creerHoroscope(h1, c1, m1, p4,p2,p1);
                monGEHoroscope.creerHoroscope(h2, c2, m2, p4,p2,p1);
                monGEHoroscope.creerHoroscope(h3, c3, m4, p4,p2,p1);
                monGEHoroscope.creerHoroscope(h4, c3, m5, p4,p2,p1);
                monGEHoroscope.creerHoroscope(h5, c4, m6, p4,p2,p1);
                monGEHoroscope.creerHoroscope(h6, c2, m7, p4,p2,p1);
                monGEHoroscope.creerHoroscope(h7, c5, m8, p4,p2,p1);
                monGEHoroscope.creerHoroscope(h8, c6, m9, p4,p2,p1);
                monGEHoroscope.creerHoroscope(h9, c7, m10, p4,p2,p1);
                monGEHoroscope.creerHoroscope(h10, c8, m11, p4,p2,p1);
                

                JpaUtil.validerTransaction();
            }
            catch (Exception ex) 
            {
                JpaUtil.annulerTransaction();
                Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                JpaUtil.fermerEntityManager();
            }
        }
        catch (Exception e) 
        {
            //Probleme de creation du contexte de persistance
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
                            /****************************
                            /  SERVICES POUR IHM CLIENT  /
                            *****************************/
    
    
    public void ajouterClient(Client unClient)
    {
        JpaUtil.log("Service : ajouterClient");
        try 
        {
            JpaUtil.init();
            JpaUtil.creerEntityManager();
            JpaUtil.ouvrirTransaction();
            ClientDao monGestionnaireEntites = new ClientDaoJpa();
            monGestionnaireEntites.creerClient(unClient);
            JpaUtil.validerTransaction();
            JpaUtil.fermerEntityManager();
        }
        catch (Exception ex) 
        {
            JpaUtil.annulerTransaction();
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public List<Medium> listerMediums ()
    {
        JpaUtil.log("Service : listerMediums");
        try 
        {
            JpaUtil.init();
            JpaUtil.creerEntityManager();
            JpaUtil.ouvrirTransaction();

            MediumDao monGE = new MediumDaoJpa();
            List<Medium>  mediums = (List<Medium>)monGE.trouverTousMediums();

            JpaUtil.validerTransaction();
            JpaUtil.fermerEntityManager();
            return mediums;
        }
        catch (Exception ex) 
        {
            JpaUtil.annulerTransaction();
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }

    public void choisirMediums(Client unClient, List<Medium> mediums)
    {
        JpaUtil.log("Service : choisirMediums");
        try 
        {
            JpaUtil.init();
            JpaUtil.creerEntityManager();
            JpaUtil.ouvrirTransaction();
            ClientDao monGE = new ClientDaoJpa();
            monGE.choisirMediums(unClient, mediums);
            JpaUtil.validerTransaction();
            JpaUtil.fermerEntityManager();
        }
        catch (Exception ex) 
        {
            JpaUtil.annulerTransaction();
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Medium trouverMediumAvecId(long unId)
    {
        JpaUtil.log("Service : trouverMediumAvecId");
        Medium m;
        try 
        {
            JpaUtil.init();
            JpaUtil.creerEntityManager();
            JpaUtil.ouvrirTransaction();

            MediumDao monGE = new MediumDaoJpa();
            m = monGE.trouverMediumAvecID(unId);

            JpaUtil.validerTransaction();
            JpaUtil.fermerEntityManager();
            return m;
        }
        catch (Exception ex) 
        {
            JpaUtil.annulerTransaction();
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
    
    public void affecterClientAEmploye(Client client)
    {
        JpaUtil.log("Service : affecterClientAEmploye");
        Medium m;
        try 
        {
            JpaUtil.init();
            JpaUtil.creerEntityManager();
            JpaUtil.ouvrirTransaction();
            
            EmployeDao monGE = new EmployeDaoJpa();
            Employe e = monGE.moinsDeClients();
            monGE.ajouterClient(e, client);
            
            JpaUtil.validerTransaction();
            JpaUtil.fermerEntityManager();
        }
        catch (Exception ex) 
        {
            JpaUtil.annulerTransaction();
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void envoiMailClient (Client client, EnvoyeurMail envoyeur)
    {
        String contenu = "Bonjour " + client.getPrenom() + " " + client.getNom() + " et bienvenue chez Predict'IF ! \n";
        contenu += "Votre numero client est : " + client.getNumClient() + "\n";
        contenu += "Votre horoscope est actuellement étudié par vos médiums favoris ! \n";
        envoyeur.envoi(ADRESSE_EXPEDITEUR, client.getAddElectronique(), "Bienvenue sur Predict'IF", contenu);
    }
    
    
                           /******************************
                           /  SERVICES POUR IHM EMPLOYE   /
                           *******************************/
    
    public Employe trouverEmployeAvecPseudoEtMDP(String unPseudo, String unMDP)
    {
        JpaUtil.log("Service : trouverEmployeAvecPseudoEtMDP");
        Employe emp;
        try 
        {
            JpaUtil.init();
            JpaUtil.creerEntityManager();
            JpaUtil.ouvrirTransaction();

            EmployeDao monGestionnaireEntites = new EmployeDaoJpa();
            emp = monGestionnaireEntites.trouverEmployeAvecPseudoEtMdp(unPseudo, unMDP);

            JpaUtil.validerTransaction();
            JpaUtil.fermerEntityManager();
            return emp;
        }
        catch (Exception ex) 
        {
            JpaUtil.annulerTransaction();
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
    
    public List<Employe> listerEmployes ()
    {
        JpaUtil.log("Service : listerEmployes");
        try 
        {
            JpaUtil.init();
            JpaUtil.creerEntityManager();
            JpaUtil.ouvrirTransaction();

            EmployeDao monGE = new EmployeDaoJpa();
            List<Employe>  employes = (List<Employe>)monGE.listerEmployes();

            JpaUtil.validerTransaction();
            JpaUtil.fermerEntityManager();
            return employes;
        }
        catch (Exception ex) 
        {
            JpaUtil.annulerTransaction();
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
    
    public List<Client> listerClients (Employe employe)
    {
        JpaUtil.log("Service : listerClients");
        try 
        {
            JpaUtil.init();
            JpaUtil.creerEntityManager();
            JpaUtil.ouvrirTransaction();

            ClientDao monGE = new ClientDaoJpa();
            List<Client>  clients = (List<Client>)monGE.classesPourChoixEmploye(employe);

            JpaUtil.validerTransaction();
            JpaUtil.fermerEntityManager();
            return clients;
        }
        catch (Exception ex) 
        {
            JpaUtil.annulerTransaction();
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
    
    public Client trouverClientAvecId(long unId)
    {
        JpaUtil.log("Service : trouverClientAvecId");
        Medium m;
        try 
        {
            JpaUtil.init();
            JpaUtil.creerEntityManager();
            JpaUtil.ouvrirTransaction();

            ClientDao monGE = new ClientDaoJpa();
            Client c = monGE.trouverClientAvecId(unId);

            JpaUtil.validerTransaction();
            JpaUtil.fermerEntityManager();
            return c;
        }
        catch (Exception ex) 
        {
            JpaUtil.annulerTransaction();
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
    
    public List<Medium> listerMediumsClient (Client client)
    {
        JpaUtil.log("Service : listerMediumsClient");
        try 
        {
            JpaUtil.init();
            JpaUtil.creerEntityManager();
            JpaUtil.ouvrirTransaction();

            ClientDao monGE = new ClientDaoJpa();
            List<Medium>  mediums = (List<Medium>)monGE.listerMediumsFavoris(client);

            JpaUtil.validerTransaction();
            JpaUtil.fermerEntityManager();
            return mediums;
        }
        catch (Exception ex) 
        {
            JpaUtil.annulerTransaction();
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
    
    public List<Prediction> listerPredictionsTriees ()
    {
        JpaUtil.log("Service : listerPredictionsTriees");
        try 
        {
            JpaUtil.init();
            JpaUtil.creerEntityManager();
            JpaUtil.ouvrirTransaction();

            PredictionDao monGE = new PredictionDaoJpa();
            List<Prediction>  mediums = (List<Prediction>)monGE.trierPredictionAvecType();

            JpaUtil.validerTransaction();
            JpaUtil.fermerEntityManager();
            return mediums;
        }
        catch (Exception ex) 
        {
            JpaUtil.annulerTransaction();
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Prediction trouverPredictionAmourAvecId(long id)
    {
        JpaUtil.log("Service : trouverPredictionAmourAvecId");
        Prediction p;
        try 
        {
            JpaUtil.init();
            JpaUtil.creerEntityManager();
            JpaUtil.ouvrirTransaction();

            PredictionDao monGE = new AmourDaoJpa();
            p = monGE.trouverPredictionAvecId(id);

            JpaUtil.validerTransaction();
            JpaUtil.fermerEntityManager();
            return p;
        }
        catch (Exception ex) 
        {
            JpaUtil.annulerTransaction();
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
    
    public Prediction trouverPredictionSanteAvecId(long id)
    {
        JpaUtil.log("Service : trouverPredictionSanteAvecId");
        Prediction p;
        try 
        {
            JpaUtil.init();
            JpaUtil.creerEntityManager();
            JpaUtil.ouvrirTransaction();

            PredictionDao monGE = new SanteDaoJpa();
            p = monGE.trouverPredictionAvecId(id);

            JpaUtil.validerTransaction();
            JpaUtil.fermerEntityManager();
            return p;
        }
        catch (Exception ex) 
        {
            JpaUtil.annulerTransaction();
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
    
    public Prediction trouverPredictionTravailAvecId(long id)
    {
        JpaUtil.log("Service : trouverPredictionTravailAvecId");
        Prediction p;
        try 
        {
            JpaUtil.init();
            JpaUtil.creerEntityManager();
            JpaUtil.ouvrirTransaction();

            PredictionDao monGE = new TravailDaoJpa();
            p = monGE.trouverPredictionAvecId(id);

            JpaUtil.validerTransaction();
            JpaUtil.fermerEntityManager();
            return p;
        }
        catch (Exception ex) 
        {
            JpaUtil.annulerTransaction();
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
    
    public Horoscope creerHoroscope(Horoscope horoscope, Client client, Medium medium, Prediction predAmour, Prediction predSante, Prediction predTravail)
    {
        JpaUtil.log("Service : ajouterClient");
        try 
        {
            JpaUtil.init();
            JpaUtil.creerEntityManager();
            JpaUtil.ouvrirTransaction();
            HoroscopeDao monGE = new HoroscopeDaoJpa();
            monGE.creerHoroscope(horoscope, client, medium, predAmour, predSante, predTravail);
            
            JpaUtil.validerTransaction();
            JpaUtil.fermerEntityManager();
            return horoscope;
        }
        catch (Exception ex) 
        {
            JpaUtil.annulerTransaction();
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * Génère le contenu d'un email à partir d'un horoscope sans rien envoyer
     * @param horoscope L'horoscope utilisé
     * @return Le contenu de l'email
     */
    public String genererContenuMail(Horoscope horoscope) 
    {
        Client client = horoscope.getClient();
        List<Prediction> predictions= horoscope.getPredictions();


        String contenu = client.getPrenom() + " " + client.getNom() + "\n";
        contenu += client.getAddPostale() + "\n";
        contenu += client.getNumTelephone() + "\n";
        contenu += "Votre numero client : " + client.getNumClient() + "\n";
        contenu += "Votre signe astrologique : " + client.getSigne().getSigne() + "\n";

        contenu += "Vos mediums favoris : ";
        boolean premier = true;
        for(Medium medium : client.getMediums()) {
            if(premier) {
                premier = false;
            } else {
                contenu += ", ";
            }
            contenu += medium.getPseudo();
        }
        contenu += "\n\n";

        Date now = new Date();
        contenu += "Le " + new SimpleDateFormat("dd/mm/yyyy").format(now);
        contenu += "\n\n";

        String particule = (client.getCivilite()=='m') ? "" : "e";
        contenu += "Cher" + particule + " " + client.getPrenom() +  ", aujourd'hui votre voyance vous est offerte par " + horoscope.getMedium().getPseudo();
        contenu += "\n\n";


        for(Prediction p : predictions) 
        {
            contenu+="["+p.getNumero()+"] ";
            contenu += p.getType()+" (";
            for(int i = 0; i < p.getPositivite(); i++) {
                contenu += p.getIcone();
            }
            contenu += ") : " + p.getPrevision();
            
            if(p.getType().equals("Sante"))
            {
                Sante s = (Sante)p;
                contenu += "Notre conseil : " + s.getConseil();
            }
            else if(p.getType().equals("Amour"))
            {
                Amour a = (Amour)p;
                contenu += "Votre signe partenaire : " + a.getPartenaire().getSigne();
            }
            contenu += "\n\n";

        }
        return contenu;
    }
    
    /**
     * Envoie un mail au client contenant son horoscope
     * @param horoscope Le nouvel horoscope à envoyer
     * @param envoyeur Le service envoyant l'email
     */
    public void envoiHoroscopeClient (Horoscope horoscope, EnvoyeurMail envoyeur){
        envoyeur.envoi(
                ADRESSE_EXPEDITEUR,
                horoscope.getClient().getAddElectronique(),
                "Votre horoscope",
                genererContenuMail(horoscope)
        );
    }
}
