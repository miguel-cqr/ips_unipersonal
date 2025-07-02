package com.ips.model;

import com.mysql.jdbc.Connection;
import com.ips.db.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.time.LocalDate;

public class CitasDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conn = null;
    DB conexion = null;

    public ArrayList<String> listarHorariosPorFecha(LocalDate fecha) {
        ArrayList<String> lista = new ArrayList<>();
        try {
            conn = conexion.getConexion();
            String query = "SELECT * FROM citas WHERE fecha = ?";
            ps = conn.prepareStatement(query);
            ps.setObject(1, fecha);
            rs = ps.executeQuery();
            while (rs.next()) {
                if(lista.contains(rs.getString("hora"))) {

                }
                else
                {
                    lista.add(rs.getString("hora"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally { 
            try { 
                rs.close(); 
            } 
            catch (Exception e) {
                 /* ignored */ 
            }
        }
        ArrayList<String> horarios = new ArrayList<>();
        horarios.add("08:00");
        horarios.add("09:00");
        horarios.add("10:00");
        horarios.add("11:00");
        horarios.add("12:00");
        horarios.add("13:00");
        horarios.add("14:00");
        horarios.add("15:00");
        horarios.add("16:00");
        for(String h : lista) {
            if(horarios.contains(h)) {
                horarios.remove(h);
            }
        }
        return horarios;
    }
    public ArrayList<Citas> busquedaPorCedula(String cedula) {
        ArrayList<Citas> lista = new ArrayList<>();
        try {
            conn = conexion.getConexion();
            String query = "SELECT * FROM citas WHERE cedulaPaciente = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, cedula);
            rs = ps.executeQuery();
            while (rs.next()) {
                Citas c = new Citas();
                c.setNombrePaciente(rs.getString("nombrePaciente"));
                c.setIdpaciente(rs.getString("cedulaPaciente"));
                c.setTelefono(rs.getString("telefono"));
                c.setFecha(rs.getObject("fecha", java.time.LocalDate.class));
                c.setHora(rs.getString("hora"));
                c.setServicio(rs.getString("servicio"));
                c.setEmail(rs.getString("email"));
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally { 
            try { 
                rs.close(); 
            } 
            catch (Exception e) {
                 /* ignored */ 
            }
        }
        return lista;
    }
    public void agregar(Citas c) {

        try {
            conn = conexion.getConexion();
            String query = "INSERT INTO citas (nombrePaciente, cedulaPaciente, telefono, fecha, hora, servicio, email) values (?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, c.getNombrePaciente()); 
            ps.setString(2, c.getIdpaciente()); 
            ps.setString(3, c.getTelefono()); 
            ps.setObject(4, c.getFecha()); 
            ps.setString(5, c.getHora()); 
            ps.setString(6, c.getServicio()); 
            ps.setString(7, c.getEmail());
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Cita agendada correctamente.");
            } else {
                System.out.println("Error al agendar la cita.");
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally { 
            try { 
                rs.close(); 
            } 
            catch (Exception e) {
                 /* ignored */ 
            }
        }
    }
}