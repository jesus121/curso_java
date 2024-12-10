package org.example.persistencia;

import org.example.logica.Empleado;
import org.example.persistencia.exceptions.NonexistentEntityException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();

    public void crearEmpleado(Empleado empleado) {

        empleadoJPA.create(empleado);
    }

    public void borrarEmpleado(Long id) {
        try {
            empleadoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Empleado> traerEmpleado () {
        return empleadoJPA.findEmpleadoEntities();
    }

    public void modificarEmpleado (Empleado empleado) {

        try {
            empleadoJPA.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Hacer una busqueda
    public List<Empleado> traerEmpleadoPorCargo(String tipoEncargo){
        List<Empleado> todos = empleadoJPA.findEmpleadoEntities();
        List<Empleado> buscados = new ArrayList<>();

        //Recorro la lista y verifico el tipo
        for(Empleado empleado : todos){
            if (empleado.getCargo().equalsIgnoreCase(tipoEncargo)){
                buscados.add(empleado);
            }
        }
        return buscados;
    }
    public Empleado traerUnEmpleado (Long id) {

        try {
            return empleadoJPA.findEmpleado(id);
        }catch (Exception exception){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, exception);
        }
        return null;
    }


}
