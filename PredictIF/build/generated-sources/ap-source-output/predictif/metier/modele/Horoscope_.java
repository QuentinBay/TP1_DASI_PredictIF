package predictif.metier.modele;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import predictif.metier.modele.Client;
import predictif.metier.modele.Medium;
import predictif.metier.modele.Prediction;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-03T04:43:36")
@StaticMetamodel(Horoscope.class)
public class Horoscope_ { 

    public static volatile SingularAttribute<Horoscope, Date> date;
    public static volatile SingularAttribute<Horoscope, Client> client;
    public static volatile SingularAttribute<Horoscope, Long> id;
    public static volatile SingularAttribute<Horoscope, Medium> medium;
    public static volatile ListAttribute<Horoscope, Prediction> predictions;

}