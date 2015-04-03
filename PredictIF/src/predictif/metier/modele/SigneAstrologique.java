
package predictif.metier.modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe de l'objet métier signe astrologique
 * @author Alexis Papin & Quentin Bayart
 */
@Entity
public class SigneAstrologique implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Identifiant unique
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**
     * Nom du signe astrologique
     */
    private String signe;
    
    /**
     * Mois
     */
    private int mois;

/*-------------------------------GETTERS & SETTERS--------------------------------*/
    /**
     * 
     * @return 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @return 
     */
    public String getSigne() {
        return signe;
    }
    
    /**
     * 
     * @param signe 
     */
    public void setSigne(String signe) {
        this.signe = signe;
    }
    
    /**
     * 
     * @return 
     */
    public int getMois() {
        return mois;
    }
    
    /**
     * 
     * @param mois 
     */
    public void setMois(int mois) {
        this.mois = mois;
    }
    
/*---------------------------------CONSTRUCTEURS----------------------------------*/
   /**
    * Constructeur par défaut
    */
    public SigneAstrologique () {}
    
    /**
     * Créé un signe astrologique
     * @param unMois un mois
     */
    public SigneAstrologique (int unMois)
    {
        mois=unMois;
        switch(mois) {
            case 0:
                    signe = "Capricorne";
                    break;
            case 1:
                    signe = "Verseau";
                    break;
            case 2:
                    signe = "Poisson";
                    break;
            case 3:
                    signe = "Belier";
                    break;
            case 4:
                    signe = "Taureau";
                    break;
            case 5:
                    signe = "Gemeaux";
                    break;
            case 6:
                    signe = "Cancer";
                    break;
            case 7:
                    signe = "Lion";
                    break;
            case 8:
                    signe = "Vierge";
                    break;
            case 9:
                    signe = "Balance";
                    break;
            case 10:
                    signe = "Scorpion";
                    break;
            case 11:
                    signe = "Sagitaire";
                    break;
        }
    }
    
/*------------------------------------METHODES------------------------------------*/
    @Override
    public int hashCode() 
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) 
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SigneAstrologique)) 
        {
            return false;
        }
        SigneAstrologique other = (SigneAstrologique) object;
        if ((this.id == null && other.id != null) || 
                (this.id != null && !this.id.equals(other.id))) 
        {
            return false;
        }
        return true;
    }

    /**
     * Gère l'affichage d'un signe astrologique
     * @return un affichage
     */
    @Override
    public String toString() {
        return "Mois n°"+mois+" : "+signe;
    }
}
