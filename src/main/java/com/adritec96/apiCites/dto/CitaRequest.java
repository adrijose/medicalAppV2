package com.adritec96.apiCites.dto;

import com.adritec96.apiCites.model.Cita;

import java.sql.Timestamp;
import java.util.Date;

public class CitaRequest implements Request {
    private int id;
    private Timestamp fechaHora;
    private String motivo;
    private int attr11;

    public CitaRequest(int id, Timestamp fechaHora, String motivo, int attr11) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.attr11 = attr11;
    }

    public Cita toModel(){
        return new Cita(id, fechaHora ,motivo,attr11);
    }

    public int getId() {
        return id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public int getAttr11() {
        return attr11;
    }
}
