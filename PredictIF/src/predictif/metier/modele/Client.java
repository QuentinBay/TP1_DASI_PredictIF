/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.metier.modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author qbayart
 */
@Entity
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numClient;
    private char civilite;
    private String nom;
    private String prenom;
     @Temporal(TemporalType.DATE)
     private Date dateNaissance;
    private String addPostale;
    private String numTelephone;
    private String addElectronique;
    
    @ManyToOne
    private SigneAstrologique signe;
    
    @ManyToMany
    private List<Medium> mediums;

    
    /*------------------------------------ GETTERS & SETTERS ----------------------------------*/
    public Long getNumClient() {
        return numClient;
    }
    
    public char getCivilite() {
        return civilite;
    }
    public void setCivilite(char civilite) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public Date getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAddPostale() {
        return addPostale;
    }
    public void setAddPostale(String addPostale) {
        this.addPostale = addPostale;
    }

    public String getNumTelephone() {
        return numTelephone;
    }
    public void setNumTelephone(String numTelephone) {
        this.numTelephone = numTelephone;
    }

    public String getAddElectronique() {
        return addElectronique;
    }
    public void setAddElectronique(String addElectronique) {
        this.addElectronique = addElectronique;
    }
    
    /* --------------------------------------- CONSTRUCTEURS ---------------------------------- */
    public Client() {}

    
    public Client ( char aCivilite, String aNom, String aPrenom, Date aDateNaissance, String anAddPostale,
                    String aNumTelephone, String anAddElectronique)
    {
        civilite = aCivilite;
        nom = aNom;
        prenom = aPrenom;
        dateNaissance = aDateNaissance;
        addPostale = anAddPostale;
        numTelephone = aNumTelephone;
        addElectronique = anAddElectronique;
        signe = null;
        mediums = new Vector();
    }
    
    /* --------------------------------------- METHODES --------------------------------------- */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numClient != null ? numClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the numClient fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.numClient == null && other.numClient != null) || (this.numClient != null && !this.numClient.equals(other.numClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "predictif.Client[ numClient=" + numClient + " ]";
    }
    
    public void addMedium ( Medium unMedium )
    {
        this.mediums.add(unMedium);
    }
    
    public void removeMedium (Medium unMedium)
    {
        this.mediums.remove(unMedium);
    }
}
