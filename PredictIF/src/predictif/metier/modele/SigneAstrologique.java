
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
import javax.persistence.Id;

/**
 *
 * @author qbayart
 */
@Entity
public class SigneAstrologique implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String signe;
    private int mois;

    
    

    /*------------------------------------ Getters et Setters ------------------------------------------*/
    public Long getId() {
        return id;
    }

    public String getSigne() {
        return signe;
    }
    public void setSigne(String signe) {
        this.signe = signe;
    }
    
	 public int getMois() {
        return mois;
    }
    public void setMois(int mois) {
        this.mois = mois;
    }
    
    /* --------------------------------------- CONSTRUCTEURS ---------------------------------- */
    public SigneAstrologique () {}
    
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SigneAstrologique)) {
            return false;
        }
        SigneAstrologique other = (SigneAstrologique) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "predictif.metier.modele.SigneAstrologique[ id=" + id + " ]";
    }
}
