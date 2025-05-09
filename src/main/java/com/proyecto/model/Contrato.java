package com.proyecto.model;

import java.time.LocalDate;

public class Contrato {
    private int id;
    private int idCliente;
    private int idServicio;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double costoTotal;
    private String estado;

    public Contrato(int id, int idCliente, int idServicio, LocalDate fechaInicio, LocalDate fechaFin, double costoTotal, String estado) {
        this.id = id;
        this.idCliente = idCliente;
        this.idServicio = idServicio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costoTotal = costoTotal;
        this.estado = estado;
    }

    public String verEstadoContrato() {
        return estado;
    }

    public double calcularCosto() {
        return costoTotal;
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

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
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

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Contrato ID: " + id +
               "\nCliente ID: " + idCliente +
               "\nServicio ID: " + idServicio +
               "\nInicio: " + fechaInicio +
               "\nFin: " + fechaFin +
               "\nCosto Total: " + costoTotal +
               "\nEstado: " + estado;
    }
}

