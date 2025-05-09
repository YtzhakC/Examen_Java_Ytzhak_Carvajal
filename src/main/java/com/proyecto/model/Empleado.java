package com.proyecto.model;

import java.util.HashMap;
import java.util.Map;

public class Empleado {
    private int id;
    private String nombre;
    private String cargo;
    private double salario;
    private String especialidad;
    private Map<Integer, Integer> horasPorProyecto; // ProyectoID -> Horas

    public Empleado(int id, String nombre, String cargo, double salario, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
        this.especialidad = especialidad;
        this.horasPorProyecto = new HashMap<>();
    }

    public void asignarProyecto(int idProyecto) {
        horasPorProyecto.putIfAbsent(idProyecto, 0);
    }

    public void registrarHorasTrabajadas(int idProyecto, int horas) {
        horasPorProyecto.merge(idProyecto, horas, Integer::sum);
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Map<Integer, Integer> getHorasPorProyecto() {
        return horasPorProyecto;
    }

    public void setHorasPorProyecto(Map<Integer, Integer> horasPorProyecto) {
        this.horasPorProyecto = horasPorProyecto;
    }

    
}
