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
        JpaUtil.init();
        JpaUtil.creerEntityManager();
        
        try 
        {
            JpaUtil.ouvrirTransaction();

            ClientDao monGestionnaireEntites = new ClientDaoJpa();
            monGestionnaireEntites.creerClient(unClient);

            JpaUtil.validerTransaction();
        }
        catch (Exception ex) {
            JpaUtil.annulerTransaction();
            Logger.getLogger(JpaUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            JpaUtil.fermerEntityManager();
        }
    }
}
