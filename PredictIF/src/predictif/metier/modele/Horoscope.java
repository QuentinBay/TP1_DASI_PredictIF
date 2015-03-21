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
public class Horoscope implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @ManyToMany
    private List<Prediction> predictions;
    
    @ManyToOne
    private Client client;
    
    @ManyToOne
    private Medium medium;

/*--------------------------------------- GETTERS & SETTERS --------------------------------------*/
    public Long getId() {
        return id;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public List getPredictions() {
        return predictions;
    }

    public void setPredictions(List<Prediction> predictions) {
        this.predictions = predictions;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }
    
/* ------------------------------------------- CONSTRUCTEURS ------------------------------------- */
    public Horoscope () {}
    
    public Horoscope ( Date date )
    {
        this.date=date;
        predictions=new Vector();
        client=null;
        medium=null;
    }
    
/* ----------------------------------------- METHODES ------------------------------------------ */
    
    public void ajouterPrediction (Prediction unePrediction)
    {
        predictions.add(unePrediction);
    }
    
    public void supprimerPrediction( Prediction unePrediciton)
    {
        /*Iterator it = predictions.iterator();

        while(it.hasNext())
        {
            if(it.numero == unePrediction)
            {
                it.remove();
                break;
            }
        }*/
        predictions.remove(unePrediciton);
    }
    
    public void supprimerToutesPredictions()
    {
        predictions.clear();
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
        if (!(object instanceof Horoscope)) {
            return false;
        }
        Horoscope other = (Horoscope) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "predictif.metier.modele.Horoscope[ id=" + id + " ]";
    }
}