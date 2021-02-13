package com.adritec96.apiCites.dto;


import com.adritec96.apiCites.model.entity.Medico;

import java.util.List;
import java.util.stream.Collectors;


public class MedicoResponse extends UsuarioResponse implements Response {

    private String ncol;
    private List<PacienteResponse> pacientes;


    public static MedicoResponse toResponse(Medico medico){
        MedicoResponse response = new MedicoResponse();
        response.setId(medico.getId() );
        response.setNombre(medico.getNombre());
        response.setApellidos(medico.getApellidos());
        response.setUsuario(medico.getUsuario());
        response.setNcol( medico.getNcol() );
        response.setPacientes(
                medico.getPacientes().stream().map(PacienteResponse::toResponse).collect(Collectors.toList())
        );
        return response;
    }

    public String getNcol() {
        return ncol;
    }

    public void setNcol(String ncol) {
        this.ncol = ncol;
    }

    public List<PacienteResponse> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<PacienteResponse> pacientes) {
        this.pacientes = pacientes;
    }
}
