package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Proceso;

public class ProcesoDAO extends DAO<Proceso>{
    public  ProcesoDAO(){
        super(new Proceso());
    }
    public Proceso getOneById(Proceso proceso)
            throws HibernateException{
        return super.getOneById(proceso.getIdProceso());
    }
}
