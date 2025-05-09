package com.proyecto.DAO;

import com.proyecto.db.Conexion;
import com.proyecto.model.Servicio;
import java.sql.*;
import java.util.*;

public class ServicioDAO {
    public static void registrarServicio(Servicio servicio) {
        try (Connection con = Conexion.getConnection()) {
            String sql = "INSERT INTO servicio (nombre, descripcion, precio_por_hora, categoria) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, servicio.getNombre());
            stmt.setString(2, servicio.getDescripcion());
            stmt.setDouble(3, servicio.getPrecioPorHora());
            stmt.setString(4, servicio.getCategoria());
            stmt.executeUpdate();
            System.out.println("Servicio registrado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar servicio: " + e.getMessage());
        }
    }

    public static List<Servicio> listarPorCategoria(String categoria) {
        List<Servicio> lista = new ArrayList<>();
        try (Connection con = Conexion.getConnection()) {
            String sql = "SELECT * FROM servicio WHERE categoria = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, categoria);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Servicio s = new Servicio(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio_por_hora"),
                    rs.getString("categoria")
                );
                lista.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar servicios: " + e.getMessage());
        }
        return lista;
    }
}

