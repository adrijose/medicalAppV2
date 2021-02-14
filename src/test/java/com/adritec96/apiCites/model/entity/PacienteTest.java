package com.adritec96.apiCites.model.entity;

import com.adritec96.apiCites.dto.PacienteRequest;
import com.adritec96.apiCites.dto.PacienteResponse;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PacienteTest {

    private static int id = 0;

    public static Paciente create( ArrayList medicos){
        Paciente mokPaciente = new Paciente();
        mokPaciente.setId(id++);
        mokPaciente.setNombre("adri");
        mokPaciente.setApellidos("perez");
        mokPaciente.setUsuario("adrijose");
        mokPaciente.setClave("peperuto");

        mokPaciente.setNns("2332556");
        mokPaciente.setNumTarjeta("52325532");
        mokPaciente.setTelefono("611611611");
        mokPaciente.setDireccion("calle piruleta");
        mokPaciente.setMedicos( medicos );
        return mokPaciente;
    }

    public static PacienteRequest createRequest(){
        PacienteRequest request = new PacienteRequest();
        request.setNombre("pepito");
        request.setApellidos("ramirez");
        request.setUsuario("pepe22");
        request.setClave("325322");
        request.setNns("FSAIKGSAI");
        request.setNumTarjeta("523523253");
        request.setTelefono("611611611");
        request.setDireccion("calle de la pasion");
        return request;
    }

}