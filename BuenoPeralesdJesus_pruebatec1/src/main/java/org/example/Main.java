package org.example;

import org.example.logica.Empleado;
import org.example.persistencia.ControladoraPersistencia;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Declaracion del scanner
        Scanner scanner = new Scanner(System.in);
        //Creacion de la tabla
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();
        // Creación de una lista
        List<Empleado> listaEmpleado;
        // variable
        Long id = 0L ;
        System.out.println("Para insertar un empeado introduzca un 1 ");
        System.out.println("Para modificar un empleado introduzca un 2 ");
        System.out.println("Para eliminar un empleado intruduzca un 3 ");
        System.out.println("Para buscar un empleado por su encargo  introduzca un 4");
        System.out.println("Para mostrar los empleados introduzca un 5");
       int eleccion = scanner.nextInt();

        switch (eleccion){
            case 1 :
                //insertar empleado
                // Pedir los datos del empleado
                System.out.println("Ingrese el nombre del empleado");
                scanner.nextLine();
                String nombre =scanner.nextLine();
                System.out.println("ingrese el apellido del empleado");
                String apellido = scanner.nextLine();
                System.out.println("Ingrese el cargo del empleado");
                String cargo = scanner.nextLine();
                System.out.println("Ingrese el salario del empleado");
                Double salario = scanner.nextDouble() ;
                System.out.println("Ingrese la fecha del empleado");
                scanner.nextLine();
                String fecha = scanner.nextLine();
                //Crea el empleado y lo pone en la base de BD
                controlPersis.crearEmpleado(new Empleado(nombre,apellido,cargo,salario,fecha));

                break;
            case 2 :
                //modificar empleado
                // Pide el id del empleado existente para poderlo cambiar 
                System.out.println("Ponga el Id a modificar");
                id = scanner.nextLong();
                Empleado idEmpleado = controlPersis.traerUnEmpleado(id);
                System.out.println("el empleado es : " +idEmpleado.toString());
                System.out.println("inserte un numero del 1 al 5 para cambiar un campo de dicho empleado");
                System.out.println("campo que puedes modificar son : el 1 es el nombre , el 2 es el apellido , el 3 es el cargo , el 4 es el salario , el 5 es la fecha");
                int modificacion=scanner.nextInt();

                // Lista para seleccionar que quiere cambiar
                switch (modificacion){
                    case 1 :
                        System.out.println("Introduzca el cambio del nombre ");
                        scanner.nextLine();
                        String nombreCambio = scanner.nextLine();
                        idEmpleado.setNombre(nombreCambio);
                        controlPersis.modificarEmpleado(idEmpleado);
                        break;
                    case 2 :
                        System.out.println("Introduzca el cambio del apellido");
                        scanner.nextLine();
                        String apellidoCambio = scanner.nextLine();
                        idEmpleado.setApellido(apellidoCambio);
                        controlPersis.modificarEmpleado(idEmpleado);
                        break;
                    case 3 :
                        System.out.println("Introduzca el cambio del cargo");
                        scanner.nextLine();
                        String cargoCambio = scanner.nextLine();
                        idEmpleado.setCargo(cargoCambio);
                        controlPersis.modificarEmpleado(idEmpleado);
                        break;
                    case 4 :
                        System.out.println("Introduzca el cambio del salario");
                        double salarioCambio = scanner.nextDouble();
                        idEmpleado.setSalario(salarioCambio);
                        controlPersis.modificarEmpleado(idEmpleado);
                        break;
                    case 5 :
                        System.out.println("Introduzca el cambio de la fecha ");
                        scanner.nextLine();
                        String fechaCambio = scanner.nextLine();
                        idEmpleado.setFecha(fechaCambio);
                        controlPersis.modificarEmpleado(idEmpleado);
                        break;
                    default:
                        System.out.println("La opción elegida no existe ");
                        break;
                }
                break;
            case 3:
                //eliminar empleado
                listaEmpleado = controlPersis.traerEmpleado();

                //Mostrar todos los empleados
                for (Empleado empleado : listaEmpleado) {
                    System.out.println(empleado.toString());
                }
                // eliminacion de un empleado
                System.out.println("¿Qué empleado quieres eliminar? ponga su id");
                id = scanner.nextLong();
                controlPersis.borrarEmpleado(id);
                break;
            case 4:
                //busqueda empleado por cargo
                System.out.println("Inserte el cargo que desa buscar");
                // Insertar el encargo
                scanner.nextLine();
                String cargoBusqueda=scanner.nextLine();

                listaEmpleado= controlPersis.traerEmpleadoPorCargo(cargoBusqueda);

                for (Empleado empleado2 : listaEmpleado) {
                    System.out.println(empleado2.toString());
                }
                break;
            case 5 :
                // mostrar toda la lista
                //lista de empleado
                listaEmpleado = controlPersis.traerEmpleado();

                //Mostrar todos los empleados
                for (Empleado empleado : listaEmpleado) {
                    System.out.println(empleado.toString());
                }
                break;
            default:
                System.out.println("La elección elegida no es valida");
                break;
        }
    }
}