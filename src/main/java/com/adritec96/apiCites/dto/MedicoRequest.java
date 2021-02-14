package com.adritec96.apiCites.dto;

import com.adritec96.apiCites.model.entity.Medico;

import java.util.ArrayList;
import java.util.Objects;

public class MedicoRequest extends UsuarioRequest implements Request {
    private String ncol;


    public Medico toModel(){
        Medico medico = new Medico();
        medico.setNombre(super.getNombre());
        medico.setApellidos(super.getApellidos());
        medico.setUsuario(super.getUsuario());
        medico.setClave(super.getClave());
        medico.setNcol(ncol);
        medico.setPacientes( new ArrayList<>() );
        return medico;
    }

    public String getNcol() {
        return ncol;
    }

    public void setNcol(String ncol) {
        this.ncol = ncol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MedicoRequest request = (MedicoRequest) o;
        return Objects.equals(ncol, request.ncol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ncol);
    }

    @Override
    public String toString() {
        return "MedicoRequest{" +
                super.toString() +
                ", ncol='" + ncol + '\'' +
                '}';
    }
}
