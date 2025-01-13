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
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;
import logica.Turno;

/**
 *
 * @author jesus
 */
@WebServlet(name = "SvFiltradoTurnos", urlPatterns = {"/SvFiltradoTurnos"})
public class SvFiltradoTurnos extends HttpServlet {

    private final Controladora controlLogica = new Controladora();
    private List<Turno> listaTurno = new ArrayList<>();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        listaTurno = controlLogica.traerTurno();
        
        String fecha = request.getParameter("fecha_turno_filtrado");
        
        String estado = request.getParameter("estado_turno_filtrado");
        System.out.println(estado);
        
        //Convertir la fecha de String a LocalDate
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Function <String , LocalDate> ConvertirFecha = fecha1 -> LocalDate.parse(fecha, formato);
        LocalDate fechaLocalDate = ConvertirFecha.apply(fecha);
        
        System.out.println(fechaLocalDate);
        
        //Procedimiento para el filtrado
        if (estado == null){
        List<Turno> turnosFiltrados = listaTurno.stream()
                .filter(fechaFiltrada -> fechaFiltrada.getFecha().equals(fechaLocalDate))
                .collect(Collectors.toList());
        request.setAttribute("turnosFiltrados", turnosFiltrados);
        }else {
            List<Turno> turnosFiltrados = listaTurno.stream()
                .filter(fechaFiltrada -> fechaFiltrada.getFecha().equals(fechaLocalDate)
                        && fechaFiltrada.getEstado().equalsIgnoreCase(estado))
                .collect(Collectors.toList());
        request.setAttribute("turnosFiltrados", turnosFiltrados);
        }
        
       
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
