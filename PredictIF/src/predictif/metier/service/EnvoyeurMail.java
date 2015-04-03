package predictif.metier.service;

/**
 * Définit l'interface d'un envoyeur de mail générique
 * @author Alexis Papin & Quentin Bayart
 */
public interface EnvoyeurMail {
    /**
     *  Envoie un mail à un destinataire
     * @param expediteur L'adresse de la personne envoyant le mail
     * @param destinataire L'adresse du destinataire du message
     * @param objet L'objet du message
     * @param contenu Contenu du message
     */
    void envoi(String expediteur, String destinataire, String objet, String contenu);
}
