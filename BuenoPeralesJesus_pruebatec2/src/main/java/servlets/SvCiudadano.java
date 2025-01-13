/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Ciudadano;
import logica.Controladora;

/**
 *
 * @author jesus
 */
@WebServlet(name = "SvCiudadano", urlPatterns = {"/SvCiudadano"})
public class SvCiudadano extends HttpServlet {

    private final Controladora controlLogica = new Controladora();
    private List<Ciudadano> listaCiudadano =new ArrayList<>() ;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //Traemos la lista de ciudadano de la base de dato
        listaCiudadano = controlLogica.traerCiudadano();
        // Establecer los resultados en la solicitud para que se muestren en el JSP
        request.setAttribute("ciudadanos", listaCiudadano);
        // Redirigir de vuelta al formulario
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        //Creacion de Ciudadano
        String nombre = request.getParameter("nombre_ciudadano");
        String apellido = request.getParameter("apellido_ciudadano");
        
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setNombre(nombre);
        ciudadano.setApellido(apellido);
   
        
        //modificacion la lista por el método crear
        controlLogica.crearCiudadano(ciudadano);
        
        // Redirigir de vuelta al formulario
        response.sendRedirect("index.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
