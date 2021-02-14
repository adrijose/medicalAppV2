
CREATE TABLE pacientes(
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(70) NOT NULL,
    direccion VARCHAR(150) NOT NULL,
    nns VARCHAR(30) NOT NULL UNIQUE,
    num_tarjeta VARCHAR(30) NOT NULL UNIQUE,
    telefono VARCHAR(20) NOT NULL,
    usuario VARCHAR(50) NOT NULL,
    clave VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE medicos(
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(70) NOT NULL,
    ncol VARCHAR(50) NOT NULL UNIQUE,
    usuario VARCHAR(50) NOT NULL,
    clave VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE diagnosticos(
    id INT NOT NULL AUTO_INCREMENT,
    enfermedad VARCHAR(70) NOT NULL,
    valoracion VARCHAR(200) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE citas(
    id INT NOT NULL AUTO_INCREMENT,
    fecha_hora DATETIME NOT NULL,
    motivo VARCHAR(200) NOT NULL,
    medico_id INT NOT NULL,
    paciente_id INT NOT NULL,
    diagnostico INT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (medico_id) REFERENCES medicos(id),
    FOREIGN KEY (paciente_id) REFERENCES pacientes(id),
    FOREIGN KEY (diagnostico) REFERENCES diagnosticos(id)
);



CREATE TABLE medico_paciente(
    medico_id INT NOT NULL,
    paciente_id INT NOT NULL,
    CONSTRAINT relacionunica UNIQUE (medico_id,paciente_id)
);

