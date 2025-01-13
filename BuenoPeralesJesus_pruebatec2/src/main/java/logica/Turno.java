/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author jesus
 */
@Entity
public class Turno implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id ; 
    int numero ; 
    LocalDate fecha ; 
    String descripcion ;
    String estado ; 
    
    @ManyToOne
    private Ciudadano ciudadano;

    public Turno() {
    }

    public Turno(int numero, LocalDate fecha, String descripcion, String estado, Ciudadano ciudadano) {
        this.numero = numero;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.estado = estado;
        this.ciudadano = ciudadano;
    }

 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }
    
   
}
