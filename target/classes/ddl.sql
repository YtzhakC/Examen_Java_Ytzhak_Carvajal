CREATE DATABASE IF NOT EXISTS soluciones_eficientes;
USE soluciones_eficientes;

-- CLIENTE
CREATE TABLE Cliente (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Representante VARCHAR(100),
    Correo VARCHAR(100),
    Telefono VARCHAR(20),
    Direccion VARCHAR(200),
    Sector VARCHAR(50) CHECK (Sector IN ('Tecnología', 'Salud', 'Educación', 'Comercio', 'Manufactura'))
);

-- SERVICIO
CREATE TABLE Servicio (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Descripcion TEXT,
    PrecioPorHora DECIMAL(12, 2),
    Categoria VARCHAR(50) CHECK (Categoria IN ('TI', 'Limpieza', 'Seguridad', 'Administración'))
);

-- CONTRATO
CREATE TABLE Contrato (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    ID_Cliente INT,
    ID_Servicio INT,
    FechaInicio DATE,
    FechaFin DATE,
    CostoTotal DECIMAL(15, 2),
    Estado VARCHAR(50) CHECK (Estado IN ('Activo', 'En espera', 'Finalizado')),
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente(ID),
    FOREIGN KEY (ID_Servicio) REFERENCES Servicio(ID)
);

-- PROYECTO
CREATE TABLE Proyecto (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    ID_Cliente INT,
    Nombre VARCHAR(100),
    FechaInicio DATE,
    FechaFin DATE,
    Estado VARCHAR(50) CHECK (Estado IN ('En curso', 'Completado', 'Cancelado')),
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente(ID)
);

-- EMPLEADO
CREATE TABLE Empleado (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100),
    Cargo VARCHAR(100),
    Salario DECIMAL(12, 2),
    Especialidad VARCHAR(50) CHECK (Especialidad IN ('TI', 'Administración', 'Limpieza', 'Seguridad'))
);

-- ASIGNACIÓN
CREATE TABLE Asignacion (
    ID_Empleado INT,
    ID_Proyecto INT,
    HorasTrabajadas INT,
    FechaAsignacion DATE,
    PRIMARY KEY (ID_Empleado, ID_Proyecto),
    FOREIGN KEY (ID_Empleado) REFERENCES Empleado(ID),
    FOREIGN KEY (ID_Proyecto) REFERENCES Proyecto(ID)
);

-- Clientes
INSERT INTO Cliente (Nombre, Representante, Correo, Telefono, Direccion, Sector)
VALUES ('TecnoGlobal', 'Laura Martínez', 'laura@tecnoglobal.com', '3001234567', 'Calle 10 #20-30', 'Tecnología'),
       ('Clínica Vida', 'Carlos Ruiz', 'carlos@clinicavida.com', '3012345678', 'Carrera 50 #25-40', 'Salud');

-- Servicios
INSERT INTO Servicio (Nombre, Descripcion, PrecioPorHora, Categoria)
VALUES ('Desarrollo de Software', 'Desarrollo de aplicaciones a medida', 120000, 'TI'),
       ('Limpieza Industrial', 'Limpieza en instalaciones industriales', 30000, 'Limpieza');

-- Empleados
INSERT INTO Empleado (Nombre, Cargo, Salario, Especialidad)
VALUES ('Juan Pérez', 'Analista de Sistemas', 3500000, 'TI'),
       ('Marta Gómez', 'Supervisora', 2000000, 'Limpieza');
