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
    private ClientDao clientDao= new ClientDaoJpa();
    
/*------------------------------CONSTRUCTEURS---------------------------------*/
    public Service ()
    {
        
    }
/*---------------------------------METHODES-----------------------------------*/
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
