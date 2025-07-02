package com.ips.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ips.model.CitasDAO;

@WebServlet("/Disponibilidad")
public class VerificarDisponibilidad extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fechaString = request.getParameter("fecha");
        LocalDate fecha = LocalDate.parse(fechaString);
        ArrayList<String> listaHorarios = new ArrayList<String>(new CitasDAO().listarHorariosPorFecha(fecha));
        if (listaHorarios.isEmpty()) {
            request.setAttribute("mensaje", "No hay horarios disponibles para la fecha seleccionada.");
            request.getRequestDispatcher("views/disponibilidadPorFecha.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("horarios", listaHorarios);
            request.getRequestDispatcher("views/disponibilidadPorFecha.jsp").forward(request, response);
        }
    }
}
