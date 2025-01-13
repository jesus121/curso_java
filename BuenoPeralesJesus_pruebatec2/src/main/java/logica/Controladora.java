/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.List;
import java.util.logging.Logger;
import persistencia.ControladoraPersistencia;

/**
 *
 * @author jesus
 */
public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
     //--------------Ciudadano--------------
    public void crearCiudadano (Ciudadano ciudadano){
        controlPersis.crearCiudadano(ciudadano);
    }
    
    public void eliminarCiudadano (Long id){
        controlPersis.eliminarCiudadano(id);
    }
    
    public List<Ciudadano> traerCiudadano(){
        return controlPersis.traerCiudadano();
    }
    
    public void editarCiudadano (Ciudadano ciudadano){
        controlPersis.editartCiudadano(ciudadano);
    }
    
    public Ciudadano traerCiudadanoId(Long id){        
        return controlPersis.traerCiudadanoId(id) ;
    }
    //--------------Turnos--------------
     public void crearTurno (Turno turno){
        controlPersis.crearTurno(turno);
    }
    
    public void eliminarTurno (Long id){
        controlPersis.eliminarTurno(id);
    }
    
    public List<Turno> traerTurno(){
        return controlPersis.traerTurno();
    }
    
    public void editarTurno (Turno turno){
        controlPersis.editartTurno(turno);
    }
}
