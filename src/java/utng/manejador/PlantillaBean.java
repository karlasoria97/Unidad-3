package utng.manejador;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import utng.modelo.Usuario;

@ManagedBean(name="plantillaBean")
@ViewScoped
public class PlantillaBean implements Serializable{
    public void checkLogin(){
        try{
            FacesContext context= FacesContext.getCurrentInstance();
            Usuario usuario =(Usuario)context.getExternalContext().getSessionMap().get("usuario");
            if(usuario==null){
                context.getExternalContext().redirect("login.xhtml");
            }
        }catch(Exception e){
            
        }
    }
}
