
package predictif.metier.modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

/**
 * Classe abstraite de l'objet métier prédiction
 * @author Alexis Papin & Quentin Bayart
 */
@Entity
//Precision du type d heritage : Toutes les predictions dans une seule table
@Inheritance (strategy = InheritanceType.SINGLE_TABLE) 
public abstract class Prediction implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Identifiant unique
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**
     * type de la prédiction
     */
    String type=null;
    
    /**
     * numéro de la prédiction
     */
    private int numero;
    
    /**
     * pisitivité de la prédiction
     */
    private int positivite;
    
    /**
     * Texte de la prédiction
     */
    private String prevision;
    
    /**
     * Icone pour la positivité
     */
    private String icone;

    /*--------------------------------------- GETTERS & SETTERS --------------------------------------*/
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
    public int getNumero() {
        return numero;
    }
    
    /**
     * 
     * @param numero 
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * 
     * @return 
     */
    public int getPositivite() {
        return positivite;
    }
    
    /**
     * 
     * @param positivite 
     */
    public void setPositivite(int positivite) {
        this.positivite = positivite;
    }
    
    /**
     * 
     * @return 
     */
    public String getPrevision() {
        return prevision;
    }
    
    /**
     * 
     * @param prevision 
     */
    public void setPrevision(String prevision) {
        this.prevision = prevision;
    }

    /**
     * 
     * @return 
     */
    public String getIcone() {
        return icone;
    }
    
    /**
     * 
     * @param icone 
     */
    public void setIcone(String icone) {
        this.icone = icone;
    }

    /**
     * 
     * @return 
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type 
     */
    public void setType(String type) {
        this.type = type;
    }
    
    
/* --------------------------------------- CONSTRUCTEURS ---------------------------------- */
    /**
     * Constructeur par défaut
     */
    public Prediction () {}
    
    /**
     * Créé une prédiction
     * @param numero un numéro
     * @param positivite une positivité
     * @param prevision une prédiction
     * @param icone une icone
     */
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

    /**
     * Gère l'affichage d'une prédiction
     * @return un affichage
     */
    @Override
    public String toString() {
        return "Prediction "+type+" n°"+id+" (" + positivite + icone + ") : " + prevision.substring(0, 15) + "...";
    }
}