package com.proyecto;

import java.time.LocalDate;
import java.util.Scanner;

import com.proyecto.DAO.ClienteDAO;
import com.proyecto.DAO.ContratoDAO;
import com.proyecto.DAO.ServicioDAO;
import com.proyecto.model.Cliente;
import com.proyecto.model.Contrato;
import com.proyecto.model.Servicio;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== Soluciones Eficientes S.A.S. ===");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Servicios");
            System.out.println("3. Gestión de Contratos");
            System.out.println("4. Gestión de Proyectos");
            System.out.println("5. Gestión de Empleados");
            System.out.println("6. Reportes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    menuClientes(sc);
                    break;
                case 2:
                    menuServicios(sc);
                    break;
                case 3:
                    menuContratos(sc);
                    break;
                case 4:
                    menuProyectos(sc);
                    break;
                case 5:
                    menuEmpleados(sc);
                    break;
                case 6:
                    menuReportes(sc);
                    break;
                case 0:
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    private static void menuClientes(Scanner sc) {
    int opcion;
    do {
        System.out.println("\n--- Gestión de Clientes ---");
        System.out.println("1. Registrar nuevo cliente");
        System.out.println("2. Listar todos los clientes");
        System.out.println("0. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        opcion = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        switch (opcion) {
            case 1:
                System.out.print("Nombre de la empresa: ");
                String nombre = sc.nextLine();
                System.out.print("Representante legal: ");
                String representante = sc.nextLine();
                System.out.print("Correo electrónico: ");
                String correo = sc.nextLine();
                System.out.print("Teléfono: ");
                String telefono = sc.nextLine();
                System.out.print("Dirección: ");
                String direccion = sc.nextLine();
                System.out.print("Sector (Tecnología, Salud, Educación, Comercio, Manufactura): ");
                String sector = sc.nextLine();

                Cliente nuevoCliente = new Cliente(nombre, representante, correo, telefono, direccion, sector);
                ClienteDAO.registrarCliente(nuevoCliente);
                break;

            case 2:
                var lista = ClienteDAO.listarClientes();
                if (lista.isEmpty()) {
                    System.out.println("No hay clientes registrados.");
                } else {
                    System.out.println("\n--- Lista de Clientes ---");
                    lista.forEach(System.out::println);
                }
                break;

            case 0:
                System.out.println("Volviendo al menú principal...");
                break;

            default:
                System.out.println("Opción inválida.");
        }

    } while (opcion != 0);
}


    private static void menuServicios(Scanner sc) {
    int opcion;
    do {
        System.out.println("\n--- Gestión de Servicios ---");
        System.out.println("1. Registrar nuevo servicio");
        System.out.println("2. Consultar servicios por categoría");
        System.out.println("0. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                System.out.print("Nombre del servicio: ");
                String nombre = sc.nextLine();
                System.out.print("Descripción: ");
                String descripcion = sc.nextLine();
                System.out.print("Precio por hora: ");
                double precio = sc.nextDouble();
                sc.nextLine();
                System.out.print("Categoría (TI, Limpieza, Seguridad, Administración): ");
                String categoria = sc.nextLine();

                Servicio nuevo = new Servicio(nombre, descripcion, precio, categoria);
                ServicioDAO.registrarServicio(nuevo);
                break;

            case 2:
                System.out.print("Ingrese la categoría a consultar: ");
                String cat = sc.nextLine();
                var servicios = ServicioDAO.listarPorCategoria(cat);
                if (servicios.isEmpty()) {
                    System.out.println("No hay servicios en esa categoría.");
                } else {
                    servicios.forEach(System.out::println);
                }
                break;

            case 0:
                System.out.println("Volviendo...");
                break;

            default:
                System.out.println("Opción no válida.");
        }
    } while (opcion != 0);
}


    public static void menuContratos(Scanner sc) {
    int opcion;
    do {
        System.out.println("\n--- Gestión de Contratos ---");
        System.out.println("1. Registrar nuevo contrato");
        System.out.println("2. Consultar contratos activos por cliente");
        System.out.println("3. Finalizar contrato");
        System.out.println("0. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
        opcion = Integer.parseInt(sc.nextLine());

        switch (opcion) {
            case 1:
                System.out.print("ID del cliente: ");
                int idCliente = Integer.parseInt(sc.nextLine());
                System.out.print("ID del servicio: ");
                int idServicio = Integer.parseInt(sc.nextLine());
                System.out.print("Fecha de inicio (YYYY-MM-DD): ");
                String fi = sc.nextLine();
                System.out.print("Fecha de fin (YYYY-MM-DD): ");
                String ff = sc.nextLine();
                System.out.print("Costo total: ");
                double costo = Double.parseDouble(sc.nextLine());
                System.out.print("Estado (Activo, En espera, Finalizado): ");
                String estado = sc.nextLine();

                Contrato contrato = new Contrato(idCliente, idServicio, LocalDate.parse(fi), LocalDate.parse(ff), costo, estado);
                ContratoDAO.registrarContrato(contrato);
                break;

            case 2:
                System.out.print("Ingrese el ID del cliente: ");
                int clienteId = Integer.parseInt(sc.nextLine());
                var contratos = ContratoDAO.buscarContratosPorCliente(clienteId);
                if (contratos.isEmpty()) {
                    System.out.println("No hay contratos activos para este cliente.");
                } else {
                    contratos.forEach(System.out::println);
                }
                break;

            case 3:
                System.out.print("Ingrese el ID del contrato a finalizar: ");
                int idContrato = Integer.parseInt(sc.nextLine());
                ContratoDAO.finalizarContrato(idContrato);
                break;

            case 0:
                System.out.println("Volviendo al menú principal...");
                break;

            default:
                System.out.println("Opción inválida.");
        }

    } while (opcion != 0);
}


    private static void menuProyectos(Scanner sc) {
        System.out.println("-> Gestión de Proyectos (pendiente implementación)");
    }

    private static void menuEmpleados(Scanner sc) {
        System.out.println("-> Gestión de Empleados (pendiente implementación)");
    }

    private static void menuReportes(Scanner sc) {
        System.out.println("-> Reportes (pendiente implementación)");
    }
}
