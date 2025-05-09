package com.proyecto.DAO;

import com.proyecto.model.Proyecto;
import com.proyecto.db.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProyectoDAO {

    public static void crearProyecto(Proyecto proyecto) {
        String sql = "INSERT INTO proyecto (id_cliente, nombre, fecha_inicio, fecha_fin, estado) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, proyecto.getIdCliente());
            ps.setString(2, proyecto.getNombre());
            ps.setDate(3, Date.valueOf(proyecto.getFechaInicio()));
            ps.setDate(4, Date.valueOf(proyecto.getFechaFin()));
            ps.setString(5, proyecto.getEstado());

            ps.executeUpdate();
            System.out.println("Proyecto creado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al crear proyecto: " + e.getMessage());
        }
    }

    public static List<Proyecto> obtenerProyectosActivos(int idCliente) {
        List<Proyecto> proyectos = new ArrayList<>();
        String sql = "SELECT * FROM proyecto WHERE id_cliente = ? AND estado = 'En curso'";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Proyecto p = new Proyecto(
                    rs.getInt("id"),
                    rs.getInt("id_cliente"),
                    rs.getString("nombre"),
                    rs.getDate("fecha_inicio").toLocalDate(),
                    rs.getDate("fecha_fin").toLocalDate(),
                    rs.getString("estado")
                );
                proyectos.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener proyectos: " + e.getMessage());
        }

        return proyectos;
    }
}