package predictif.util;

import predictif.metier.service.EnvoyeurMail;

/**
 * Définit un faux envoyeur de mail (sur STDOUT)
 * @author Maria Baboulall & Robin Ricard
 */
public class SimulationEnvoyeurMail implements EnvoyeurMail {

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
