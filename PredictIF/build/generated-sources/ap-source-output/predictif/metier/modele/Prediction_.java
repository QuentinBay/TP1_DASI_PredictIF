package predictif.metier.modele;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-03T07:48:04")
@StaticMetamodel(Prediction.class)
public abstract class Prediction_ { 

    public static volatile SingularAttribute<Prediction, Integer> numero;
    public static volatile SingularAttribute<Prediction, Integer> positivite;
    public static volatile SingularAttribute<Prediction, String> icone;
    public static volatile SingularAttribute<Prediction, Long> id;
    public static volatile SingularAttribute<Prediction, String> type;
    public static volatile SingularAttribute<Prediction, String> prevision;

}