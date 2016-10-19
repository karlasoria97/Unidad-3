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
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Karla Soria karlasopa03@gmail.com
 */
@Entity
@Table(name="proceso")
public class Proceso implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_proceso")
    private Long idProceso;
    @Column(name = "nombre", length = 100)
    private String nombre;
    @Column(name="numero_proceso")
    private int numeroProceso;
    @Column(name="Descripcion", length = 200)
    private String descripcion;
    public Proceso(Long idProceso, String nombre, int numeroProceso, String descripcion){
        super();
        this.idProceso=idProceso;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.numeroProceso=numeroProceso;
    }
    public Proceso(){
        this(0L,"",0, "");
    }

    public Long getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Long idProceso) {
        this.idProceso = idProceso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroProceso() {
        return numeroProceso;
    }

    public void setNumeroProceso(int numeroProceso) {
        this.numeroProceso = numeroProceso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
        
}
