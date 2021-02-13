package com.adritec96.apiCites.dto;

import com.adritec96.apiCites.model.Diagnostico;


public class DiagnosticoRequest implements Request {
    private String valoracionEspecialista;
    private String enfermedad;

    public DiagnosticoRequest( String valoracionEspecialista, String enfermedad) {
        this.valoracionEspecialista = valoracionEspecialista;
        this.enfermedad = enfermedad;
    }

    public Diagnostico toModel(){
        return new Diagnostico(valoracionEspecialista, enfermedad);
    }

    public String getValoracionEspecialista() {
        return valoracionEspecialista;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

}
