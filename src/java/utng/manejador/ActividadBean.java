package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.datos.ActividadDAO;
import utng.modelo.Actividad;
import utng.datos.ProcesoDAO;
import utng.datos.RolDAO;
import utng.modelo.Proceso;
import utng.modelo.Rol;
import utng.modelo.Usuario;


@ManagedBean(name = "actividadBean")
@SessionScoped
public class ActividadBean implements Serializable {

    private List<Actividad> actividades;
    private Actividad act;
    private List<Proceso> procesos;
    private List<Rol> roles;

    public ActividadBean() {
        act = new Actividad();
        act.setProceso(new Proceso());
        act.setRol(new Rol());
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
   

    public List<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(List<Proceso> procesos) {
        this.procesos = procesos;
    }
    

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public Actividad getAct() {
        return act;
    }

    public void setAct(Actividad act) {
        this.act = act;
    }

    public String listar() {
        ActividadDAO dao = new ActividadDAO();
        try {
            actividades = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Actividades";
    }

    public String eliminar() {
        ActividadDAO dao = new ActividadDAO();
        try {
            dao.delete(act);
            actividades = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }

    public String iniciar() {
        act = new Actividad();
        act.setProceso(new Proceso());
        act.setRol(new Rol());
        try {
            procesos = new ProcesoDAO().getAll();
            roles = new RolDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Iniciar";
    }

    public String guardar() {
        ActividadDAO dao = new ActividadDAO();
        try {
            if (act.getIdActividad()!= 0) {
                dao.update(act);
            } else {
                dao.insert(act);
            }
            actividades = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }

    public String cancelar() {
        return "Cancelar";
    }

    public String editar(Actividad act) {
        this.act = act;
        try{
            procesos = new ProcesoDAO().getAll();
            roles = new RolDAO().getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Editar";
    }
}
