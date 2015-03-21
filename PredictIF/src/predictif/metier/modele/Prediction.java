

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

/**
 *
 * @author qbayart
 */
@Entity
public abstract class Prediction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int numero;
    private int positivite;
    private String prevision; //Texte de la prediction
    private String icone;

    /*--------------------------------------- GETTERS & SETTERS --------------------------------------*/
   
    public Long getId() {
        return id;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPositivite() {
        return positivite;
    }
    
    public void setPositivite(int positivite) {
        this.positivite = positivite;
    }
    
    public String getPrevision() {
        return prevision;
    }
    
    public void setPrevision(String prevision) {
        this.prevision = prevision;
    }

    public String getIcone() {
        return icone;
    }
    
    public void setIcone(String icone) {
        this.icone = icone;
    }
    
    
/* --------------------------------------- CONSTRUCTEURS ---------------------------------- */
    public Prediction () {}
    
    public Prediction (int numero, int positivite, String prevision, String icone)
    {
        this.numero=numero;
        this.positivite=positivite;
        this.prevision=prevision;
        this.icone=icone;
    }
    
/* ----------------------------------------- METHODES ------------------------------------------ */
    
     @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prediction)) {
            return false;
        }
        Prediction other = (Prediction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "predictif.metier.modele.Prediction[ id=" + id + " ]";
    }
}