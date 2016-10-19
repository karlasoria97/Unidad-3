package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Actividad;

public class ActividadDAO extends DAO<Actividad>{
    public ActividadDAO(){
        super(new Actividad());
    }
    
    public Actividad getOneById(Actividad act)
            throws HibernateException{
        return super.getOneById(act.getIdActividad());
    }
}
