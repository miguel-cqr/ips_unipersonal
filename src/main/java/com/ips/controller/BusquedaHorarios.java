package com.ips.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ips.model.CitasDAO;

@WebServlet("/IngresarFecha")
public class BusquedaHorarios extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fechaString = request.getParameter("fecha");
        LocalDate fecha = LocalDate.parse(fechaString);
        ArrayList<String> listaHorarios = new ArrayList<String>(new CitasDAO().listarHorariosPorFecha(fecha));
        if (listaHorarios.isEmpty()) {
            request.setAttribute("mensaje", "No hay horarios disponibles para la fecha seleccionada, intente seleccionar otra fecha.");
            request.getRequestDispatcher("views/AgendarFecha.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("horarios", listaHorarios);
            request.setAttribute("fecha", fechaString);
            request.getRequestDispatcher("views/AgendarCita.jsp").forward(request, response);
        }
    }
}
