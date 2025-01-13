/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.Function;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;


@WebServlet(name = "SvTurnoEliminar", urlPatterns = {"/SvTurnoEliminar"})
public class SvTurnoEliminar extends HttpServlet {

   private final Controladora controlLogica = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        Function <String , Long> convertiraLong = s ->Long.parseLong(s);
        
        Long id = convertiraLong.apply(request.getParameter("id"));
        
        controlLogica.eliminarTurno(id);
         
        response.sendRedirect("index.jsp");
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
