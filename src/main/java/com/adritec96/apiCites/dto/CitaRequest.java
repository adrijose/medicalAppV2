package com.adritec96.apiCites.dto;

import com.adritec96.apiCites.model.entity.Cita;

import java.sql.Timestamp;
import java.util.Objects;

public class CitaRequest implements Request {
    private Timestamp fechaHora;
    private String motivo;

    public Cita toModel(){
        Cita cita = new Cita();
        cita.setFechaHora(fechaHora);
        cita.setMotivo(motivo);
        return cita;
    }

    public CitaResponse toResponse(){
        return CitaResponse.toResponse( toModel() );
    }

    /////////////////////////////////////////////////////


    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CitaRequest that = (CitaRequest) o;
        return Objects.equals(fechaHora, that.fechaHora) && Objects.equals(motivo, that.motivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaHora, motivo);
    }

    @Override
    public String toString() {
        return "CitaRequest{" +
                "fechaHora=" + fechaHora +
                ", motivo='" + motivo + '\'' +
                '}';
    }
}
