package com.adritec96.apiCites.dto;

import com.adritec96.apiCites.model.entity.Medico;

public class MedicoRequest extends UsuarioRequest implements Request {
    private String ncol;


    public Medico toModel(){
        Medico medico = new Medico();
        medico.setNombre(super.getNombre());
        medico.setApellidos(super.getApellidos());
        medico.setUsuario(super.getUsuario());
        medico.setClave(super.getClave());
        medico.setNcol(ncol);
        return medico;
    }
}
