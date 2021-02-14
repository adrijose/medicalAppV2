package com.adritec96.apiCites.model.entity;

import com.adritec96.apiCites.dto.MedicoRequest;
import com.adritec96.apiCites.dto.MedicoResponse;

import java.util.ArrayList;
import java.util.List;

public class MedicoPrototype {

    private static int id = 0;
    private static String name = "Ramón";
    private static String lastName = "Jimenez Perez";
    private static String username = "ramoneJP";
    private static String password = "jp83783F-225";
    private static String ncol = "53252DPG54";

    public static Medico create(ArrayList pacientes){
        Medico medico = new Medico();
        medico.setId(id++);
        medico.setNombre(name);
        medico.setApellidos(lastName);
        medico.setUsuario(username);
        medico.setClave(password);
        medico.setNcol(ncol);
        medico.setPacientes(pacientes);
        return medico;
    }

    public static MedicoRequest createRequest(){
        MedicoRequest request = new MedicoRequest();
        request.setNombre(name);
        request.setApellidos(lastName);
        request.setUsuario(username);
        request.setClave(password);
        request.setNcol(ncol);
        return request;
    }

    public static MedicoResponse createResponse(){
        return MedicoResponse.toResponse( create(new ArrayList()) );
    }

    public static MedicoResponse createResponse( ArrayList pacientes ){
        return MedicoResponse.toResponse( create( pacientes ) );
    }

}