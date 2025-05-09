package com.proyecto.model;

public class Servicio {
    private int id;
    private String nombre;
    private String descripcion;
    private double precioPorHora;
    private String categoria;

     public Servicio(String nombre, String descripcion, double precioPorHora, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioPorHora = precioPorHora;
        this.categoria = categoria;
    }

    public Servicio(int id, String nombre, String descripcion, double precioPorHora, String categoria) {
        this(nombre, descripcion, precioPorHora, categoria);
        this.id = id;
    }

    public double calcularCostoTotal(int horas) {
        return precioPorHora * horas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioPorHora() {
        return precioPorHora;
    }

    public void setPrecioPorHora(double precioPorHora) {
        this.precioPorHora = precioPorHora;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Servicio [ID=" + id + ", Nombre=" + nombre + ", Categoría=" + categoria +
                ", Precio/Hora=" + precioPorHora + "]";
    }
}
