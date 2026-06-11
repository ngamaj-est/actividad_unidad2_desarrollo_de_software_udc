CREATE DATABASE IF NOT EXISTS zoologico_db;
USE zoologico_db;

CREATE TABLE zona (
    id VARCHAR(36) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    capacidad_maxima INT NOT NULL
);

CREATE TABLE especie (
    id VARCHAR(36) PRIMARY KEY,
    nombre_espanol VARCHAR(100) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    zona_id VARCHAR(36),
    FOREIGN KEY (zona_id) REFERENCES zona(id)
);

CREATE TABLE cuidador (
    id VARCHAR(36) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(100),
    fecha_ingreso DATE NOT NULL
);

CREATE TABLE cuidador_especie (
    cuidador_id VARCHAR(36),
    especie_id VARCHAR(36),
    fecha_asignacion DATE NOT NULL,
    PRIMARY KEY (cuidador_id, especie_id),
    FOREIGN KEY (cuidador_id) REFERENCES cuidador(id),
    FOREIGN KEY (especie_id) REFERENCES especie(id)
);

CREATE TABLE guia (
    id VARCHAR(36) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(100)
);

CREATE TABLE itinerario (
    id VARCHAR(36) PRIMARY KEY,
    duracion_minutos INT NOT NULL,
    capacidad_maxima INT NOT NULL
);

CREATE TABLE itinerario_zona (
    itinerario_id VARCHAR(36),
    zona_id VARCHAR(36),
    PRIMARY KEY (itinerario_id, zona_id),
    FOREIGN KEY (itinerario_id) REFERENCES itinerario(id),
    FOREIGN KEY (zona_id) REFERENCES zona(id)
);

CREATE TABLE examen_medico (
    id VARCHAR(36) PRIMARY KEY,
    especie_id VARCHAR(36),
    tipo_examen VARCHAR(50) NOT NULL,
    fecha_realizacion DATE NOT NULL,
    FOREIGN KEY (especie_id) REFERENCES especie(id)
);

CREATE TABLE habitat (
    id VARCHAR(36) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tipo_clima VARCHAR(50),
    zona_id VARCHAR(36),
    FOREIGN KEY (zona_id) REFERENCES zona(id)
);