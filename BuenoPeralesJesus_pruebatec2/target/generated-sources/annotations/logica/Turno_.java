package logica;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Ciudadano;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2025-01-10T00:21:42")
@StaticMetamodel(Turno.class)
public class Turno_ { 

    public static volatile SingularAttribute<Turno, String> descripcion;
    public static volatile SingularAttribute<Turno, LocalDate> fecha;
    public static volatile SingularAttribute<Turno, String> estado;
    public static volatile SingularAttribute<Turno, Integer> numero;
    public static volatile SingularAttribute<Turno, Long> id;
    public static volatile SingularAttribute<Turno, Ciudadano> ciudadano;

}