
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
 * Classe objet métier Employé
 * @author Alexis Papin & Quentin Bayart
 */
@Entity
public class Employe implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Liste des clients gérés par un employé
     */
    @OneToMany
    private List<Client> clients;
    
    /**
     * Identifiant unique
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**
     * Login 
     */
    private String pseudo;
    
    /**
     * Mot de passe
     */
    private String motDePasse;
    
    /**
     * Nom
     */
    private String nom;
    
    /**
     * Prénom
     */
    private String prenom;
    
    

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
    public String getNom() {
        return nom;
    }
    
    /**
     * 
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
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
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * 
     * @param motDePasse 
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    /**
     * 
     * @return 
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * 
     * @param prenom 
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    /* --------------------------------------- CONSTRUCTEURS ---------------------------------- */
    /**
     * Constructeur par défaut
     */
    public Employe () {}
    
    /**
     * Créé un employé
     * @param unPseudo un login
     * @param unMotDePasse un mot de passe
     * @param unNom un nom
     * @param unPrenom un prénom
     */
    public Employe (String unPseudo, String unMotDePasse, String unNom, String unPrenom)
    {
        pseudo=unPseudo;
        motDePasse=unMotDePasse;
        nom=unNom;
        prenom=unPrenom;
        clients=new Vector<Client>();
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

    /**
     * Gère l'affichage d'un employé
     * @return un affichage
     */
    @Override
    public String toString() {
        return "Employe n°"+id+" : "+prenom+" "+nom+"\n"+"Login : "+pseudo+" | Mdp : "+motDePasse+"\n";
    }
    
    /**
     * Ajoute un client 
     * @param unClient un client
     */
    public void addClient (Client unClient)
    {
        this.clients.add(unClient);
    }
    
    /**
     * Retire un client
     * @param unClient un client
     */
    public void removeClient (Client unClient)
    {
        this.clients.remove(unClient);
    }
}
