package com.adritec96.apiCites.model.entity;

import com.adritec96.apiCites.dto.MedicoResponse;
import com.adritec96.apiCites.dto.PacienteRequest;
import com.adritec96.apiCites.dto.PacienteResponse;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PacientePrototype {

    private static int id = 0;
    private static String name = "Adrián";
    private static String lastName = "Ruiz Lopez";
    private static String userName = "adrijose";
    private static String pass = "346@36gwsd423435";
    private static String nns = "235223D";
    private static String numTarjeta = "856383J5567H";
    private static String tlf = "958958958";
    private static String address = "calle juan de dios";


    public static Paciente create( ArrayList medicos){
        Paciente mokPaciente = new Paciente();
        mokPaciente.setId(id++);
        mokPaciente.setNombre(name);
        mokPaciente.setApellidos(lastName);
        mokPaciente.setUsuario(userName);
        mokPaciente.setClave(pass);

        mokPaciente.setNns(nns);
        mokPaciente.setNumTarjeta(numTarjeta);
        mokPaciente.setTelefono(tlf);
        mokPaciente.setDireccion(address);
        mokPaciente.setMedicos( medicos );
        return mokPaciente;
    }

    public static PacienteRequest createRequest(){
        PacienteRequest request = new PacienteRequest();
        request.setNombre(name);
        request.setApellidos(lastName);
        request.setUsuario(userName);
        request.setClave(pass);
        request.setNns(nns);
        request.setNumTarjeta(numTarjeta);
        request.setTelefono(tlf);
        request.setDireccion(address);
        return request;
    }

    public static PacienteResponse createResponse(){
        return PacienteResponse.toResponse( create(new ArrayList()) );
    }

    public static PacienteResponse createResponse( ArrayList medicos ){
        return PacienteResponse.toResponse( create( medicos ) );
    }

}