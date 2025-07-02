package com.ips.model;

import java.time.LocalDate;

public class Citas {    
    
    private String nombrePaciente;
    private String idPaciente;
    private String telefono;
    private LocalDate fecha;
    private String hora;
    private String servicio;
    private String email;

    public Citas() {
        // Constructor por defecto
    }

    public Citas(String telefono, LocalDate fecha, String hora, String nombrePaciente, String idpaciente, String email, String servicio) {
        this.telefono = telefono;
        this.fecha = fecha;
        this.hora = hora;
        this.nombrePaciente = nombrePaciente;
        this.idPaciente = idpaciente;
        this.email = email;
        this.servicio = servicio;
    }

    // Getters y Setters
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getServicio() {
        return servicio;
    }
    
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getIdpaciente() {
        return idPaciente;
    }

    public void setIdpaciente(String idpaciente) {
        this.idPaciente = idpaciente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
