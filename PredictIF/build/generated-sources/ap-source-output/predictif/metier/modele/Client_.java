package predictif.metier.modele;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import predictif.metier.modele.Horoscope;
import predictif.metier.modele.Medium;
import predictif.metier.modele.SigneAstrologique;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-03T04:43:36")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, Long> numClient;
    public static volatile SingularAttribute<Client, String> addElectronique;
    public static volatile SingularAttribute<Client, String> addPostale;
    public static volatile ListAttribute<Client, Horoscope> horoscopes;
    public static volatile SingularAttribute<Client, Date> dateNaissance;
    public static volatile SingularAttribute<Client, String> nom;
    public static volatile SingularAttribute<Client, String> prenom;
    public static volatile SingularAttribute<Client, SigneAstrologique> signe;
    public static volatile ListAttribute<Client, Medium> mediums;
    public static volatile SingularAttribute<Client, String> numTelephone;
    public static volatile SingularAttribute<Client, Character> civilite;

}