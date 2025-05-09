package com.proyecto.model;

import java.time.LocalDate;
import java.util.List;

public class Proyecto {
    private int id;
    private int idCliente;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private List<Empleado> empleados;

    public Proyecto(int id, int idCliente, String nombre, LocalDate fechaInicio, LocalDate fechaFin, String estado, List<Empleado> empleados) {
        this.id = id;
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.empleados = empleados;
    }

    public void listarEmpleados() {
        empleados.forEach(e -> System.out.println(e.getNombre()));
    }

    public long calcularDuracion() {
        return java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    
}
