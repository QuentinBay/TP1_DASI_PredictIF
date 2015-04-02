/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.metier.service;

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
/**
 *
 * @author qbayart
 */
public class Service 
{
/*------------------------------------ATTRIBUTS-----------------------------------*/

    
/*----------------------------------CONSTRUCTEURS---------------------------------*/
    public Service ()
    {
        
    }
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
                Client c6 = new Client( 'm', "Marin", "Leo", new Date(94, 0, 5), 
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
                
/*-------------------------------CREATION MEDIUMS---------------------------------*/
                MediumDao monGEMedium = new MediumDaoJpa();
                Medium m1 = new Medium("Madame Irma");
                Medium m2 = new Medium("Madame du Soleil");
                Medium m3 = new Medium("Mamadou");
                Medium m4 = new Medium("Monsieur Tarot");
                Medium m5 = new Medium("Claire Voyance");
                Medium m6 = new Medium("Mademoiselle future");
                Medium m7 = new Medium("Paul Lepoulpe");
                Medium m8 = new Medium("Charles Atant");
                Medium m9 = new Medium("Jean Caisse");
                Medium m10 = new Medium("Dieu");
                Medium m11 = new Medium("Monsieur Voyant");
                Medium m12 = new Medium("Madame Voyante");
				
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
                PredictionDao monGEPrediction = new PredictionDaoJpa();
                Prediction p1 = new Prediction(1, 4, "Vous vous portez très bien aujourd'hui", 
                                                "image");
                Prediction p2 = new Prediction(1, 1, "Ca ne va pas fort aujourd'hui", 
					"pluie");
                Prediction p3 = new Prediction(2, 2, "Une journée plutot commune", 
                        "ordinateur");
                Prediction p4 = new Prediction(3, 4, "Une très bonne rencontre aujourd'hui", 
                        "coeur4");
                Prediction p5 = new Prediction(2, 3, "Votre travail sera reconnu", 
                        "ordinateur");
                Prediction p6 = new Prediction(1, 4, "Vous vous sentez libre comme l'air", 
                        "soleil");
                Prediction p7 = new Prediction(3, 1, "Ca ne sent pas bon pour votre couple", 
                        "coeur1");
                Prediction p8 = new Prediction(3, 2, "Une routine morose se fait sentir", 
                        "coeur2");
                Prediction p9 = new Prediction(1, 1, "Votre tête vous fait mal", 
                        "pluie");
                Prediction p10 = new Prediction(2, 4, "Une promotion vous attend", 
                        "ordinateur");
                Prediction p11 = new Prediction(1, 2, "Vous êtes un peu dans le brouillard", 
                        "nuageux");
                Prediction p12 = new Prediction(3, 3, "Tout va pour le mieux, profitez-en", 
                        "coeur3");
												
                monGEPrediction.creerPrediction(p1);
                monGEPrediction.creerPrediction(p2);
                monGEPrediction.creerPrediction(p3);
                monGEPrediction.creerPrediction(p4);
                monGEPrediction.creerPrediction(p5);
                monGEPrediction.creerPrediction(p6);
                monGEPrediction.creerPrediction(p7);
                monGEPrediction.creerPrediction(p8);
                monGEPrediction.creerPrediction(p9);
                monGEPrediction.creerPrediction(p10);
                monGEPrediction.creerPrediction(p11);
                monGEPrediction.creerPrediction(p12);
                
                
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

                monGEHoroscope.creerHoroscope(h1);
                monGEHoroscope.creerHoroscope(h2);
                monGEHoroscope.creerHoroscope(h3);
                monGEHoroscope.creerHoroscope(h4);
                monGEHoroscope.creerHoroscope(h5);
                monGEHoroscope.creerHoroscope(h6);
                monGEHoroscope.creerHoroscope(h7);
                monGEHoroscope.creerHoroscope(h8);
                monGEHoroscope.creerHoroscope(h9);
                monGEHoroscope.creerHoroscope(h10);
                

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
    
    public void ajouterClient(Client unClient)
    {
        JpaUtil.log("Service : ajouterClient");
        try 
        {
            JpaUtil.init();
            JpaUtil.creerEntityManager();

            try 
            {
                JpaUtil.ouvrirTransaction();
                
                ClientDao monGestionnaireEntites = new ClientDaoJpa();
                monGestionnaireEntites.creerClient(unClient);
                
                
                
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
    
    

}
