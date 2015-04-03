/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictif.metier.modele;

import predictif.dao.SigneAstrologiqueDao;
import predictif.dao.jpa.SigneAstrologiqueDaoJpa;
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
    
    @ManyToOne //Lien unidirectionnel
    private SigneAstrologique signe;
    
    //@ManyToOne //Lien bidirectionnel
    //private Employe employe;
    
    @ManyToMany //Lien unidirectionnel
    private List<Medium> mediums;

    @OneToMany(mappedBy="client") //Lien bidirectionnel
    private List<Horoscope> horoscopes;
    
    
    
    /*-------------------------- GETTERS & SETTERS ---------------------------*/
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
        //Lier un signe astrologique a un client
        SigneAstrologiqueDao monGESigne = new SigneAstrologiqueDaoJpa();
        SigneAstrologique signe = monGESigne.trouverSigneAstrologiqueAvecMois(dateNaissance.getMonth());
        setSigne(signe);
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

    public SigneAstrologique getSigne() {
        return signe;
    }

    public void setSigne(SigneAstrologique signe) {
        this.signe = signe;
    }

    public List<Medium> getMediums() {
        return mediums;
    }

    public void setMediums(List<Medium> mediums) {
        this.mediums = mediums;
    }

    public List<Horoscope> getHoroscopes() {
        return horoscopes;
    }

    public void setHoroscopes(List<Horoscope> horoscopes) {
        this.horoscopes = horoscopes;
    }
    
    /**
     * @return Son Employe Referent
     */
    /*public Employe getEmployeReferent() {
        return employe;
    }

    /**
     * @param employe Son nouvel employe referent
     */
    /*public void setEmployeReferent(Employe employe) {
        this.employe = employe;
    }*/

    
    /* --------------------------- CONSTRUCTEURS ---------------------------- */
    public Client() {}

    
    public Client ( char aCivilite, String aNom, String aPrenom, 
                    Date aDateNaissance, String anAddPostale,
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
        //employe=null;
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
        String retour = "Client n°" + numClient + " : \nPrenom : " + prenom + "\nNom : " + nom 
                            + "\nSigne astrologique : " + signe.getSigne() 
                            + "\nMediums : \n";
        for(Medium m : this.getMediums()) {
            retour +=" - "+m.getPseudo()+"\n";
        }
        return retour;
    }
    
    public void addMediums (List<Medium> desMediums )
    {
        mediums=desMediums;
    }
    
    
    public void addHoroscope ( Horoscope unHoroscope )
    {
        this.horoscopes.add(unHoroscope);
        unHoroscope.setClient(this);
    }
    
}
