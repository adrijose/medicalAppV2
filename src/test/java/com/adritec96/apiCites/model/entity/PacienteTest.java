package com.adritec96.apiCites.model.entity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PacienteTest {

    public static Paciente create(){
        Paciente mokPaciente = new Paciente();
        mokPaciente.setId(1);
        mokPaciente.setNombre("adri");
        mokPaciente.setApellidos("perez");
        mokPaciente.setUsuario("adrijose");
        mokPaciente.setClave("peperuto");

        mokPaciente.setNns("2332556");
        mokPaciente.setNumTarjeta("52325532");
        mokPaciente.setTelefono("611611611");
        mokPaciente.setDireccion("calle piruleta");
        mokPaciente.setMedicos( new ArrayList<Medico>() );
        return mokPaciente;
    }

}