package com.ips.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

import com.ips.model.Citas;
import com.ips.model.CitasDAO;

@WebServlet("/BuscarCedula")
public class BusquedaCedula extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cc = request.getParameter("cedula");
        ArrayList<Citas> listaCitas = new ArrayList<Citas>(new CitasDAO().busquedaPorCedula(cc));
        if (listaCitas.isEmpty()) {
            request.setAttribute("mensaje", "No se encontraron citas para la cédula ingresada.");
            request.getRequestDispatcher("views/citasPorCedula.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("citas", listaCitas);
            request.getRequestDispatcher("views/citasPorCedula.jsp").forward(request, response);
        }
       }
}