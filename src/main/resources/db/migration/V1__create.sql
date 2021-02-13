
CREATE TABLE pacientes(
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(70) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    nns VARCHAR(30) NOT NULL,
    num_tarjeta VARCHAR(50) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    usuario VARCHAR(50) NOT NULL,
    clave VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE medicos(
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(70) NOT NULL,
    ncol VARCHAR(30) NOT NULL,
    usuario VARCHAR(50) NOT NULL,
    clave VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE citas(
    id INT NOT NULL AUTO_INCREMENT,
    fecha_hora DATETIME NOT NULL,
    motivo VARCHAR(200) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE diagnosticos(
    id INT NOT NULL AUTO_INCREMENT,
    enfermedad VARCHAR(70) NOT NULL,
    valoracion VARCHAR(200) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE medico_paciente(
    medico_id INT NOT NULL,
    paciente_id INT NOT NULL,
    CONSTRAINT relacionunica UNIQUE (medico_id,paciente_id)
);

