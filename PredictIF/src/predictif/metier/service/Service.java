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

import java.util.Date;
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
/*--------------------------------ATTRIBUTS-----------------------------------*/

    
/*------------------------------CONSTRUCTEURS---------------------------------*/
    public Service ()
    {
        
    }
/*---------------------------------METHODES-----------------------------------*/
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
                /*----------------CREATION SIGNES ASTROLOGIQUES---------------*/
                SigneAstrologiqueDao monGESigneAstrologique = new SigneAstrologiqueDaoJpa();
                monGESigneAstrologique.creerTousLesSignesAstrologiques();
                
                
                /*--------------------CREATION CLIENTS------------------------*/
                ClientDao monGEClient = new ClientDaoJpa();
                Client c1 = new Client( 'm', "Quentin", "Bayart", new Date(10, 10, 94), 
                                "123 rue", "060555555", "Quentin@hotmail.fr");
                Client c2 = new Client( 'm', "Adrien", "Menella", new Date(10, 10, 93), 
                                "123 rue", "060555555", "Adrien@hotmail.fr");
                Client c3 = new Client( 'm', "Skander", "Mankai", new Date(10, 10, 95), 
                                "123 rue", "060555555", "Skander@hotmail.fr");
                Client c4 = new Client( 'm', "Kevin", "Bulme", new Date(1, 2, 94), 
                                "123 rue", "060555555", "Kevin@hotmail.fr");
                Client c5 = new Client( 'm', "Alexis", "Papin", new Date(10, 12, 94), 
                                "123 rue", "060555555", "papin@hotmail.fr");
                Client c6 = new Client( 'm', "Lisa", "Leo", new Date(10, 5, 94), 
                                "123 rue", "060555555", "papin@hotmail.fr");
                Client c7 = new Client( 'm', "Julie", "Bert", new Date(4, 8, 94), 
                                "123 rue", "060555555", "papin@hotmail.fr");
                Client c8 = new Client( 'm', "Jean", "Uhl", new Date(7, 9, 94), 
                                "123 rue", "060555555", "papin@hotmail.fr");
                Client c9 = new Client( 'm', "Charles", "Mer", new Date(10, 4, 94), 
                                "123 rue", "060555555", "papin@hotmail.fr");
                Client c10 = new Client( 'm', "Eric", "Kein", new Date(10, 2, 94), 
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
                
                /*--------------------CREATION MEDIUMS------------------------*/
                MediumDao monGEMedium = new MediumDaoJpa();
                Medium m1 = new Medium("Madame Irma");
                monGEMedium.creerMedium(m1);
                
                // TODO (faire 10 - 15 mediums) !!!!!!!!!!!!!!!!
                
                /*-------------------CREATION EMPLOYES------------------------*/
                EmployeDao monGEEmploye = new EmployeDaoJpa();
                Employe e1 = new Employe ( "Bubu", "mdp", "Thomas", "Buffard");
                monGEEmploye.creerEmploye(e1);
                // TODO (faire 10 - 15 employes) !!!!!!!!!!!!!!!!
                
                
                /*------------------CREATION PREDICTIONS----------------------*/
                PredictionDao monGEPrediction = new PredictionDaoJpa();
                Prediction p1 = new Prediction(1, 4, "Vous vous portez très bien aujourd'hui", 
                                                "image");
                monGEPrediction.creerPrediction(p1);
                
                // TODO (faire 10 - 15 predictions) !!!!!!!!!!!!!!!!
                
                
                /*-------------------CREATION HOROSCOPES----------------------*/
                HoroscopeDao monGEHoroscope = new HoroscopeDaoJpa();
                Horoscope h1 = new Horoscope(new Date(10,4,15));
                monGEHoroscope.ajouterPrediction(p1);
                
                // TODO (faire 5 - 10 horoscopes) !!!!!!!!!!!!!!!!
                

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
