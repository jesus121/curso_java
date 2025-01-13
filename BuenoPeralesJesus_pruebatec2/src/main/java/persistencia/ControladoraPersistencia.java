/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Ciudadano;
import logica.Turno;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author jesus
 */
public class ControladoraPersistencia {
    
    CiudadanoJpaController ciudadanoJpa = new  CiudadanoJpaController() ;
    TurnoJpaController turnoJpa = new TurnoJpaController();
    
    //Ciudadano
    public void crearCiudadano (Ciudadano ciudadano) {
        ciudadanoJpa.create(ciudadano);
    }
    
    public void eliminarCiudadano ( Long id){
        try {
            ciudadanoJpa.destroy(id);
        }catch (NonexistentEntityException ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    public List<Ciudadano> traerCiudadano(){
        return ciudadanoJpa.findCiudadanoEntities();
    }

    public void editartCiudadano (Ciudadano ciudadano){
        try {
            ciudadanoJpa.edit(ciudadano);
        }catch(Exception ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
     public Ciudadano traerCiudadanoId(Long id){
        try {
            return ciudadanoJpa.findCiudadano(id);
        }catch(Exception ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE,null, ex);
        } 
        return null; 
     }
    
    //Turno
    public void crearTurno (Turno turno) {
        turnoJpa.create(turno);
    }
    
    public void eliminarTurno ( Long id){
        try {
            turnoJpa.destroy(id);
        }catch (NonexistentEntityException ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    public List<Turno> traerTurno(){
        return turnoJpa.findTurnoEntities();
    }

    public void editartTurno (Turno turno){
        try {
            turnoJpa.edit(turno);
        }catch(Exception ex){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
   
    
}
