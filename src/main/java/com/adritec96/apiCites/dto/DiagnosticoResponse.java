package com.adritec96.apiCites.dto;

import com.adritec96.apiCites.model.entity.Diagnostico;

import java.util.Objects;


public class DiagnosticoResponse implements Response {
    private int id;
    private String valoracionEspecialista;
    private String enfermedad;


    public static DiagnosticoResponse toRespose(Diagnostico diagnostico){
        DiagnosticoResponse response = new DiagnosticoResponse();
        response.setId( diagnostico.getId() );
        response.setValoracionEspecialista( diagnostico.getValoracionEspecialista() );
        response.setEnfermedad( diagnostico.getEnfermedad() );
        return response;
    }

    ///////////////////////////////////////////////////////////////////////


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValoracionEspecialista() {
        return valoracionEspecialista;
    }

    public void setValoracionEspecialista(String valoracionEspecialista) {
        this.valoracionEspecialista = valoracionEspecialista;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiagnosticoResponse response = (DiagnosticoResponse) o;
        return id == response.id && Objects.equals(valoracionEspecialista, response.valoracionEspecialista) && Objects.equals(enfermedad, response.enfermedad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valoracionEspecialista, enfermedad);
    }

    @Override
    public String toString() {
        return "DiagnosticoResponse{" +
                "id=" + id +
                ", valoracionEspecialista='" + valoracionEspecialista + '\'' +
                ", enfermedad='" + enfermedad + '\'' +
                '}';
    }

}
