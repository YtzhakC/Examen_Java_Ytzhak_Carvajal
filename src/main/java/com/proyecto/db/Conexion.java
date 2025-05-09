package com.proyecto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/soluciones"; // Cambia el nombre de la BD si es distinto
    private static final String USER = "Campus2023"; // Ajusta tu usuario
    private static final String PASSWORD = "Campus2023"; // Ajusta tu contraseña

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}

