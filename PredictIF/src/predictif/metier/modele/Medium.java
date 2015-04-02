
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
public class Medium implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pseudo;
    private String photo;
    private String description;

    /*------------------------------------ GETTERS & SETTERS ----------------------------------*/
    public Long getId() {
        return id;
    }
    
    public String getPseudo() {
        return pseudo;
    }
	
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    /* --------------------------------------- CONSTRUCTEURS ---------------------------------- */
    public Medium () {}
    
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

    @Override
    public String toString() {
        return "predictif.metier.modele.Medium[ id=" + id + " ]";
    }
}
