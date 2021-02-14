package com.adritec96.apiCites.model.entity;

import com.adritec96.apiCites.dto.MedicoRequest;
import com.adritec96.apiCites.dto.MedicoResponse;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MedicoTest {

    public static Medico create(ArrayList pacientes){
        Medico medico = new Medico();
        medico.setNombre("Ramón");
        medico.setApellidos("Jimenez");
        medico.setUsuario("ramonj");
        medico.setClave("32432sfdd6663");
        medico.setNcol("325532353");
        medico.setPacientes(pacientes);
        return medico;
    }

    public static MedicoRequest createRequest(){
        MedicoRequest request = new MedicoRequest();
        request.setNombre("Pedro");
        request.setApellidos("Rubio Lios");
        request.setUsuario("prios");
        request.setClave("354543346");
        request.setNcol("FHL34FGAG32");
        return request;
    }

}