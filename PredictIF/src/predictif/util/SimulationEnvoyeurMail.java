package predictif.util;

import predictif.metier.service.EnvoyeurMail;

/**
 * Définit un faux envoyeur de mail (sur STDOUT)
 * @author Alexis Papin & Quentin Bayart
 */
public class SimulationEnvoyeurMail implements EnvoyeurMail {

    /**
     *  Envoie un mail à un destinataire
     * @param expediteur L'adresse de la personne envoyant le mail
     * @param destinataire L'adresse du destinataire du message
     * @param objet L'objet du message
     * @param contenu Contenu du message
     */
    @Override
    public void envoi(String expediteur, String destinataire, String objet, String contenu) {
        System.out.println("Expediteur : " + expediteur);
        System.out.println("Destinataire : " + destinataire);
        System.out.println("Sujet : " + objet);
        System.out.println("Corps : ");
        System.out.println(contenu);
        System.out.println("Cordialement,\nJean-Charles de Predict'IF");
    }
}
