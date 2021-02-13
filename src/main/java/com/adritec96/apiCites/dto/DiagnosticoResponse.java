package com.adritec96.apiCites.dto;

import com.adritec96.apiCites.model.entity.Diagnostico;


public class DiagnosticoResponse implements Response {
    private int id;
    private String valoracionEspecialista;
    private String enfermedad;

    public DiagnosticoResponse(int id, String valoracionEspecialista, String enfermedad) {
        this.id = id;
        this.valoracionEspecialista = valoracionEspecialista;
        this.enfermedad = enfermedad;
    }

    public static DiagnosticoResponse toRespose(Diagnostico diagnostico){
        return new DiagnosticoResponse(
                diagnostico.getId(),
                diagnostico.getValoracionEspecialista(),
                diagnostico.getEnfermedad()
        );
    }

    public int getId() {
        return id;
    }

    public String getValoracionEspecialista() {
        return valoracionEspecialista;
    }

    public String getEnfermedad() {
        return enfermedad;
    }
}
