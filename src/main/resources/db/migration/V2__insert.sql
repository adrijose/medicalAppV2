
INSERT INTO pacientes(NOMBRE,APELLIDOS,DIRECCION,NNS,NUM_TARJETA,TELEFONO,USUARIO,CLAVE)
VALUES ('Pepe','Ruiz Lopez', 'Juan Ramon Jimenez 18', '234523D44R', '5454345D', '611611611' ,'adrian10', 'ejemploaadepassword');
INSERT INTO pacientes(NOMBRE,APELLIDOS,DIRECCION,NNS,NUM_TARJETA,TELEFONO,USUARIO,CLAVE)
VALUES ('Adri','Covos Ludez', 'Maria Magdalena 28', '2312343F4', '1444345F', '601010601' ,'joselin22', 'ejemploadsesspassword');
INSERT INTO pacientes(NOMBRE,APELLIDOS,DIRECCION,NNS,NUM_TARJETA,TELEFONO,USUARIO,CLAVE)
VALUES ('Jose','Lopez Gutierrez', 'Picaso 8', '3646372FFS', '1354645D', '613613631' ,'adrijose', 'ejemplodeasdasdpasggsword');
INSERT INTO pacientes(NOMBRE,APELLIDOS,DIRECCION,NNS,NUM_TARJETA,TELEFONO,USUARIO,CLAVE)
VALUES ('Remedios','Taez Nirez', 'Vazquez ramon jimenez 18', '2436H73JHF', '0448265C', '615616617' ,'remedi0S', 'ejemplodeddasdssword');
INSERT INTO pacientes(NOMBRE,APELLIDOS,DIRECCION,NNS,NUM_TARJETA,TELEFONO,USUARIO,CLAVE)
VALUES ('Patricia','Ruiz Lopez', 'Carrusel 53', '014234H7T5', '5345665D', '614614614' ,'patricia22', 'ejemplodepasasdggrd');

INSERT INTO medicos (NOMBRE,APELLIDOS,NCOL,USUARIO,CLAVE)
VALUES ('Santiago', 'Curez Pez', '2343243235523253', 'sintagocures23', 'conttraseadieeficisdasaslderecordar');
INSERT INTO medicos (NOMBRE,APELLIDOS,NCOL,USUARIO,CLAVE)
VALUES ('Cristian', 'Cuartero Rodiguez', '2348237023474', 'cuartero22', 'conttrasefffffadifiegdcilderecordar');
INSERT INTO medicos (NOMBRE,APELLIDOS,NCOL,USUARIO,CLAVE)
VALUES ('Maria', 'Cuesta Arquella', '2343423655473253', 'marcuesta', 'conttraseadifdsssssficdfsilderecordar');
INSERT INTO medicos (NOMBRE,APELLIDOS,NCOL,USUARIO,CLAVE)
VALUES ('Pablo', 'Merino Sanchez', '234445643322577', 'psanchez', 'conttraseadifggicilderecordar');

INSERT INTO medico_paciente(medico_id,paciente_id) VALUES(1,1);
INSERT INTO medico_paciente(medico_id,paciente_id) VALUES(1,2);
INSERT INTO medico_paciente(medico_id,paciente_id) VALUES(2,1);
INSERT INTO medico_paciente(medico_id,paciente_id) VALUES(2,2);
INSERT INTO medico_paciente(medico_id,paciente_id) VALUES(1,3);

INSERT INTO diagnosticos(enfermedad,valoracion) VALUES("gripe", "mandar medicamentos");
INSERT INTO diagnosticos(enfermedad,valoracion) VALUES("dolor de espalda", "masaje en la espalda y mandar medicamentos");
INSERT INTO diagnosticos(enfermedad,valoracion) VALUES("alergia", "mandar cita para prueba de alergia");

INSERT INTO citas(fecha_hora,motivo,diagnostico,medico_id,paciente_id) VALUES("2020-01-01 09:32:00", "motivo de la cita 1", null, 1, 1);
INSERT INTO citas(fecha_hora,motivo,diagnostico,medico_id,paciente_id) VALUES("2020-05-17 10:22:00", "motivo de la cita 2", 1, 2, 1);
INSERT INTO citas(fecha_hora,motivo,diagnostico,medico_id,paciente_id) VALUES("2020-12-14 11:52:00", "motivo de la cita 3", null, 1, 3);
INSERT INTO citas(fecha_hora,motivo,diagnostico,medico_id,paciente_id) VALUES("2021-02-02 13:25:00", "motivo de la cita 4", 2, 4, 1);
INSERT INTO citas(fecha_hora,motivo,diagnostico,medico_id,paciente_id) VALUES("2020-01-01 14:42:00", "motivo de la cita 5", 3, 1, 1);