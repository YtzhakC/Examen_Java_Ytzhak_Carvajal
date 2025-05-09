package com.proyecto.DAO;

import com.proyecto.model.Contrato;
import com.proyecto.db.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratoDAO {

    public static void registrarContrato(Contrato contrato) {
        String sql = "INSERT INTO contrato (id_cliente, id_servicio, fecha_inicio, fecha_fin, costo_total, estado) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, contrato.getIdCliente());
            stmt.setInt(2, contrato.getIdServicio());
            stmt.setDate(3, Date.valueOf(contrato.getFechaInicio()));
            stmt.setDate(4, Date.valueOf(contrato.getFechaFin()));
            stmt.setDouble(5, contrato.getCostoTotal());
            stmt.setString(6, contrato.getEstado());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al registrar contrato: " + e.getMessage());
        }
    }

    public static List<Contrato> listarContratos() {
        List<Contrato> lista = new ArrayList<>();
        String sql = "SELECT * FROM contrato";

        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Contrato c = new Contrato(
                        rs.getInt("id"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_servicio"),
                        rs.getDate("fecha_inicio").toLocalDate(),
                        rs.getDate("fecha_fin").toLocalDate(),
                        rs.getDouble("costo_total"),
                        rs.getString("estado")
                );
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar contratos: " + e.getMessage());
        }

        return lista;
    }

    public static List<Contrato> buscarContratosPorCliente(int idCliente) {
        List<Contrato> lista = new ArrayList<>();
        String sql = "SELECT * FROM contrato WHERE id_cliente = ? AND estado = 'Activo'";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Contrato c = new Contrato(
                        rs.getInt("id"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_servicio"),
                        rs.getDate("fecha_inicio").toLocalDate(),
                        rs.getDate("fecha_fin").toLocalDate(),
                        rs.getDouble("costo_total"),
                        rs.getString("estado")
                );
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar contratos: " + e.getMessage());
        }

        return lista;
    }

    public static void finalizarContrato(int idContrato) {
        String sql = "UPDATE contrato SET estado = 'Finalizado' WHERE id = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idContrato);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al finalizar contrato: " + e.getMessage());
        }
    }
}
