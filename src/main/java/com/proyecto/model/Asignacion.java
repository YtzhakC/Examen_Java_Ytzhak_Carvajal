package com.proyecto.model;

import java.time.LocalDate;

public class Asignacion {
    private int idEmpleado;
    private int idProyecto;
    private int horasTrabajadas;
    private LocalDate fechaAsignacion;

    public Asignacion(int idEmpleado, int idProyecto, int horasTrabajadas, LocalDate fechaAsignacion) {
        this.idEmpleado = idEmpleado;
        this.idProyecto = idProyecto;
        this.horasTrabajadas = horasTrabajadas;
        this.fechaAsignacion = fechaAsignacion;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    // Getters y Setters
}
