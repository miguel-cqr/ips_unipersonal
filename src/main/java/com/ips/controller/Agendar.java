package com.ips.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;

import com.ips.model.Citas;
import com.ips.model.CitasDAO;

@WebServlet("/Agendar")
public class Agendar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String cc = request.getParameter("cedula");
        String telefono = request.getParameter("telefono");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        String email = request.getParameter("email");
        String servicio = request.getParameter("servicio");
        Citas cita = new Citas(telefono, LocalDate.parse(fecha), hora, nombre, cc, email, servicio);
        new CitasDAO().agregar(cita);
        response.sendRedirect("views/citaAgendada.jsp");
    }
}
