
package predictif.metier.modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe objet métier Médium
 * @author Alexis Papin & Quentin Bayart
 */
@Entity
public class Medium implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Identifiant unique
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**
     * Pseudo
     */
    private String pseudo;
    
    /**
     * Photo
     */
    private String photo;
    
    /**
     * Biographie rapide
     */
    private String description;

    /*------------------------------------ GETTERS & SETTERS ----------------------------------*/
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
    public String getPseudo() {
        return pseudo;
    }
	
    /**
     * 
     * @param pseudo 
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    
    /**
     * 
     * @return 
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 
     * @param photo 
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * 
     * @return 
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /* --------------------------------------- CONSTRUCTEURS ---------------------------------- */
    /**
     * Constructeur par défaut
     */
    public Medium () {}
    
    /**
     * Créé un médium
     * @param pseudo un pseudo
     * @param uneDescription une description
     * @param unePhoto une photo
     */
    public Medium (String pseudo, String uneDescription, String unePhoto)
    {
        this.pseudo=pseudo;
        description=uneDescription;
        photo=unePhoto;
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
        if (!(object instanceof Medium)) {
            return false;
        }
        Medium other = (Medium) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Gère l'affichage de l'objet médium
     * @return un affichage
     */
    @Override
    public String toString() {
        return "Medium n°"+id+" : "+pseudo+"\n"+description+"\n"+photo+"\n";
    }
}
