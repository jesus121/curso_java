/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Ciudadano;
import logica.Controladora;
import logica.Turno;

/**
 *
 * @author jesus
 */
@WebServlet(name = "SvTurno", urlPatterns = {"/SvTurno"})
public class SvTurno extends HttpServlet {

     private final Controladora controlLogica = new Controladora();
     private List<Ciudadano> listaCiudadano =new ArrayList<>();
    private List<Turno> listaTurno = new ArrayList<>();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
         //Traemos la lista de ciudadano de la base de dato
        listaTurno = controlLogica.traerTurno();
        // Establecer los resultados en la solicitud para que se muestren en el JSP
        request.setAttribute("turnos", listaTurno);
        // Redirigir de vuelta al formulario
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //Creacion de Turno
        int numero = Integer.parseInt(request.getParameter("numero_turno"));
        String fecha = request.getParameter("fecha_turno");
        String descripcion = request.getParameter("descripcion_turno");
        String idCiudadano = request.getParameter("id_ciudadano");
        String estado = request.getParameter("estado_turno");
        
        
         //Convertir la fecha de String a LocalDate
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Function <String , LocalDate> ConvertirFecha = fecha1 -> LocalDate.parse(fecha, formato);
        LocalDate fechaLocalDate = ConvertirFecha.apply(fecha);
        
        
        //Traer Ciudadano
        Function <String , Long> convertiraLong = s ->Long.parseLong(s);
        
        
        Turno turno = new Turno();
        turno.setNumero(numero);
        turno.setFecha(fechaLocalDate);
        turno.setDescripcion(descripcion);
        turno.setEstado(estado);
        turno.setCiudadano( controlLogica.traerCiudadanoId(convertiraLong.apply(idCiudadano)));
        
        //modificacion la lista por el método crear
        controlLogica.crearTurno(turno);
        
        // Redirigir de vuelta al formulario
        response.sendRedirect("index.jsp");
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
