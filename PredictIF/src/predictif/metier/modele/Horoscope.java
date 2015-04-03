
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
 * Objet métier horoscope
 * @author Alexis Papin & Quentin Bayart
 */
@Entity
public class Horoscope implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * Identifiant unique de l'horoscope
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    /**
     * Date de création de l'horoscope
     */
    @Temporal(TemporalType.DATE)
    private Date date;
    
    /**
     * Liste des prédictions de l'horoscope
     */
    @ManyToMany
    private List<Prediction> predictions;
    
    /**
     * Client concerné par l'horoscope
     */
    @ManyToOne
    private Client client;
    
    /**
     * Médium qui réalise l'horoscope
     */
    @ManyToOne
    private Medium medium;

/*--------------------------------------- GETTERS & SETTERS --------------------------------------*/
    /**
     * Renvoie l'id
     * @return id
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Renvoie la date
     * @return date
     */
    public Date getDate() {
        return date;
    }
    
    /**
     * Change la valeur de la date
     * @param date une date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Change la liste des prédictions
     * @param predictions une liste de prédictions
     */
    public void setPredictions(List<Prediction> predictions) {
        this.predictions = predictions;
    }

    /**
     * Change le client
     * @param client un client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Renvoie les prédictions
     * @return les prédictions
     */
    public List<Prediction> getPredictions() {
        return predictions;
    }

    /**
     * Renvoie les clients
     * @return les clients
     */
    public Client getClient() {
        return client;
    }

    /**
     * Renvoie un médium
     * @return un médium
     */
    public Medium getMedium() {
        return medium;
    }

    /**
     * Change le médium
     * @param medium un médium
     */
    public void setMedium(Medium medium) {
        this.medium = medium;
    }
    
/* ------------------------------------------- CONSTRUCTEURS ------------------------------------- */
    /**
     * Constructeur par défaut
     */
    public Horoscope () {}
    
    /**
     * Créer un horoscope à partir d'une date
     * @param date une date
     */
    public Horoscope ( Date date )
    {
        this.date=date;
        predictions=new Vector<Prediction>();
        client=null;
        medium=null;
    }
    
/* ----------------------------------------- METHODES ------------------------------------------ */
   /**
    * Ajoute un prédiction
    * @param unePrediction une prédiction
    */
    public void ajouterPrediction(Prediction unePrediction)
    {
        predictions.add(unePrediction);
    }
    
    /**
     * Supprime une prédiction
     * @param unePrediction une prédiction
     */
    public void supprimerPrediction(Prediction unePrediction)
    {
        predictions.remove(unePrediction);
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

    /**
     * Définit l'affichage de l'horoscope
     * @return forme de l'affichage
     */
    @Override
    public String toString() {
        String contenu="Horoscope n°"+id+" datant du "+date+ " : \n";
        if(!predictions.isEmpty())
        {
            for(Prediction p : predictions) 
            {
                contenu+="["+p.getNumero()+"] ";
                contenu += p.getType()+" (";
                for(int i = 0; i < p.getPositivite(); i++) {
                    contenu += p.getIcone();
                }
                contenu += ") : " + p.getPrevision();

                if(p.getType().equals("Sante"))
                {
                    Sante s = (Sante)p;
                    contenu += "\nNotre conseil : " + s.getConseil();
                }
                else if(p.getType().equals("Amour"))
                {
                    Amour a = (Amour)p;
                    contenu += "\nVotre signe partenaire : " + a.getPartenaire().getSigne();
                }
                contenu += "\n\n";

            }
        }
        return contenu;
    }
}