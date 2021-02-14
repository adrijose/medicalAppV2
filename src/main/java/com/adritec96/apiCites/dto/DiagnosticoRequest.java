package com.adritec96.apiCites.dto;

import com.adritec96.apiCites.model.entity.Diagnostico;

import java.util.Objects;


public class DiagnosticoRequest implements Request {
    private String valoracionEspecialista;
    private String enfermedad;

    public Diagnostico toModel(){
        Diagnostico diagnostico =  new Diagnostico();
        diagnostico.setValoracionEspecialista(valoracionEspecialista);
        diagnostico.setEnfermedad(enfermedad);
        return diagnostico;
    }

    public DiagnosticoResponse toResponse(){
        return DiagnosticoResponse.toRespose( toModel() );
    }


    //////////////////////////////////////////////////////////////////////////


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
        DiagnosticoRequest that = (DiagnosticoRequest) o;
        return Objects.equals(valoracionEspecialista, that.valoracionEspecialista) && Objects.equals(enfermedad, that.enfermedad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valoracionEspecialista, enfermedad);
    }

    @Override
    public String toString() {
        return "DiagnosticoRequest{" +
                "valoracionEspecialista='" + valoracionEspecialista + '\'' +
                ", enfermedad='" + enfermedad + '\'' +
                '}';
    }

}
