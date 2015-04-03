
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
 * Classe objet métier client
 * @author Alexis Papin & Quentin Bayart
 */
@Entity
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Identifiant unique
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numClient;
    /**
     * Une civilité
     */
    private char civilite;
    /**
     * Un nom
     */
    private String nom;
    /**
     * Un prénom
     */
    private String prenom;
    /**
     * Une date de naissance
     */
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    /**
     * Une adresse postale
     */
    private String addPostale;
    /**
     * Un numéro de téléphone
     */
    private String numTelephone;
    /**
     * Une adresse mail
     */
    private String addElectronique;
    /**
     * Un signe astrologique
     */
    @ManyToOne //Lien unidirectionnel
    private SigneAstrologique signe;
    /**
     * Une liste de médiums
     */
    @ManyToMany //Lien unidirectionnel
    private List<Medium> mediums;
    /**
     * Une liste d'horoscopes
     */
    @OneToMany(mappedBy="client") //Lien bidirectionnel
    private List<Horoscope> horoscopes;
    
    
    
    /*-------------------------- GETTERS & SETTERS ---------------------------*/
    /**
     * renvoie un numéro client
     * @return un numéro client
     */
    public Long getNumClient() {
        return numClient;
    }
    
    /**
     * renvoie une civilité
     * @return une civilité
     */
    public char getCivilite() {
        return civilite;
    }
    
    /**
     * change une civilité
     * @param civilite une civilité
     */
    public void setCivilite(char civilite) {
        this.civilite = civilite;
    }

    /**
     * renvoie un nom
     * @return un nom
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * change un nom
     * @param nom un nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * renvoie un prénom
     * @return un prénom
     */
    public String getPrenom() {
        return prenom;
    }
    
    /**
     * change un prénom
     * @param prenom un prénom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    /**
     * renvoie une date de naissance
     * @return une date de naissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }
    
    /**
     * change une date de naissance
     * @param dateNaissance une date de naissance
     */
    public void setDateNaissance(Date dateNaissance) {
       
        this.dateNaissance = dateNaissance;
        //Lier un signe astrologique a un client
        SigneAstrologiqueDao monGESigne = new SigneAstrologiqueDaoJpa();
        SigneAstrologique signe = monGESigne.trouverSigneAstrologiqueAvecMois(dateNaissance.getMonth());
        setSigne(signe);
    }

    /**
     * renvoie une adresse postale
     * @return une adresse postale
     */
    public String getAddPostale() {
        return addPostale;
    }
    
    /**
     * change une adresse postale
     * @param addPostale une adresse postale
     */
    public void setAddPostale(String addPostale) {
        this.addPostale = addPostale;
    }

    /**
     * renvoie un numéro de téléphone
     * @return une numéro de téléphone
     */
    public String getNumTelephone() {
        return numTelephone;
    }
    
    /**
     * change un numéro de téléphone
     * @param numTelephone un numéro de téléphone
     */
    public void setNumTelephone(String numTelephone) {
        this.numTelephone = numTelephone;
    }

    /**
     * renvoie une adresse mail
     * @return une adresse mail
     */
    public String getAddElectronique() {
        return addElectronique;
    }
    
    /**
     * change une adresse mail
     * @param addElectronique une adresse mail
     */
    public void setAddElectronique(String addElectronique) {
        this.addElectronique = addElectronique;
    }

    /**
     * renvoie un signe astrologique
     * @return un signe astrologique
     */
    public SigneAstrologique getSigne() {
        return signe;
    }

    /**
     * change un signe astrologique
     * @param signe un signe astrologique
     */
    public void setSigne(SigneAstrologique signe) {
        this.signe = signe;
    }

    /**
     * renvoie une liste de médiums
     * @return une liste de médiums
     */
    public List<Medium> getMediums() {
        return mediums;
    }

    /**
     * change une liste de médiumsune liste de médiums
     * @param mediums 
     */
    public void setMediums(List<Medium> mediums) {
        this.mediums = mediums;
    }

    /**
     * renvoie une liste d'horoscopes
     * @return une liste d'horoscopes
     */
    public List<Horoscope> getHoroscopes() {
        return horoscopes;
    }

    /**
     * Change une liste d'horoscopes
     * @param horoscopes une liste d'horoscopes
     */
    public void setHoroscopes(List<Horoscope> horoscopes) {
        this.horoscopes = horoscopes;
    }

    
    /* --------------------------- CONSTRUCTEURS ---------------------------- */
    /**
     * constructeur par défaut
     */
    public Client() {}

    /**
     * Créer un client
     * @param aCivilite une civilité
     * @param aNom un nom
     * @param aPrenom
     * un prénom
     * @param aDateNaissance une date de naissance
     * @param anAddPostale une adresse postale
     * @param aNumTelephone un numéro de téléphone
     * @param anAddElectronique une adresse mail
     */
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
    
    /**
     * Gére l'affichage de l'objet métier client
     * @return un affichage
     */
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
    
    /**
     * Ajoute une liste de médiums
     * @param desMediums des médiums
     */
    public void addMediums (List<Medium> desMediums )
    {
        mediums=desMediums;
    }
    
    /**
     * AJoute un horoscope
     * @param unHoroscope un horoscope
     */
    public void addHoroscope ( Horoscope unHoroscope )
    {
        this.horoscopes.add(unHoroscope);
        unHoroscope.setClient(this);
    }
    
}
