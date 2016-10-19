package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import utng.modelo.Proceso;
import utng.datos.ProcesoDAO;

@ManagedBean(name = "procesoBean")
@SessionScoped
public class ProcesoBean implements Serializable {

    private List<Proceso> procesos;
    private Proceso proceso;

    public ProcesoBean() {
    };
    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public List<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(List<Proceso> procesos) {
        this.procesos = procesos;
    }

    public String listar() {
        ProcesoDAO dao = new ProcesoDAO();
        try {
            procesos = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Procesos";
    }

    public String eliminar() {
        ProcesoDAO dao = new ProcesoDAO();
        try {
            dao.delete(proceso);
            procesos = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }

    public String iniciar() {
        proceso = new Proceso();
        return "Iniciar";
    }

    public String guardar() {
        ProcesoDAO dao = new ProcesoDAO();
        try {
            if (proceso.getIdProceso() != 0) {
                dao.update(proceso);
            } else {
                dao.insert(proceso);
            }
            procesos = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }

    public String cancelar() {
        return "Cancelar";
    }

    public String editar(Proceso proceso) {
        this.proceso = proceso;
        return "Editar";
    }
}
