package com.adritec96.apiCites.dto;

import com.adritec96.apiCites.model.entity.Cita;

import java.sql.Timestamp;
import java.util.Date;

public class CitaRequest implements Request {
    private Timestamp fechaHora;
    private String motivo;

    public CitaRequest(Timestamp fechaHora, String motivo) {
        this.fechaHora = fechaHora;
        this.motivo = motivo;

    }

    public Cita toModel(){
        Cita cita = new Cita();
        cita.setFechaHora(fechaHora);
        cita.setMotivo(motivo);
        return cita;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

}
