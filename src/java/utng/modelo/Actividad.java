/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 *
 * @author Karla Soria karlasopa03@gmail.com
 */
@Entity @Table(name = "actividad")
public class Actividad implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_actividad")
    private Long idActividad;
    @ManyToOne
    @JoinColumn(name = "id_proceso")
    private Proceso proceso;
    @Column(name="nombre", length = 50)
    private String nombre;
    @Column(name="descripcion", length = 200)
    private String descripcion;
    @Column(name="numero")
    private int numero;
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;
    
    public Actividad(Long idActividad, Long idProceso, String nombre, String descripcion, int numero, Proceso proceso, Rol rol){
        super();
        this.idActividad=idActividad;
        this.proceso = proceso;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.numero=numero;
        this.rol = rol;
    }
    
    public Actividad(){
        this.idActividad = 0L;
        
    }
    

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
        
}
