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
import java.util.Vector;
import java.util.List;
import java.util.Iterator;
//import javax.persistence.OneToMany;

/**
 *
 * @author qbayart
 */
@Entity
public class Employe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pseudo;
    private String motDePasse;
    private String nom;
    private String prenom;
    
    @OneToMany
    private List<Client> clients; 

    /*------------------------------------ GETTERS & SETTERS ----------------------------------*/
    public Long getId() {
        return id;
    }
    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    /* --------------------------------------- CONSTRUCTEURS ---------------------------------- */
    public Employe () {}
    
    public Employe (String unPseudo, String unMotDePasse, String unNom, String unPrenom)
    {
        pseudo=unPseudo;
        motDePasse=unMotDePasse;
        nom=unNom;
        prenom=unPrenom;
        clients=new Vector();
    }

    /* --------------------------------------- METHODES --------------------------------------- */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employe)) {
            return false;
        }
        Employe other = (Employe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "predictif.metier.modele.Employe[ id=" + id + " ]";
    }
    
    public void addClient (Client unClient)
    {
        this.clients.add(unClient);
    }
    
    public void removeClient (Client unClient)
    {
        this.clients.remove(unClient);
    }
}
