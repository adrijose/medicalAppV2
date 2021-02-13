package com.adritec96.apiCites.dto;

import com.adritec96.apiCites.model.Cita;

import java.util.Date;

public class CitaResponse implements Response {
    private int id;
    private Date fechaHora;
    private String motivo;
    private int attr11;
    private PacienteResponse paciente;
    private MedicoResponse medico;
    private DiagnosticoResponse diagnostico = null;

    public CitaResponse(int id, Date fechaHora, String motivo, int attr11, PacienteResponse paciente, MedicoResponse medico) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.attr11 = attr11;
        this.paciente = paciente;
        this.medico = medico;
    }

    public static CitaResponse toResponse(Cita cita){
        CitaResponse res = new CitaResponse(
                cita.getId(),
                cita.getFechaHora(),
                cita.getMotivo(),
                cita.getAttr11(),
                PacienteResponse.toResponse(cita.getPaciente()),
                MedicoResponse.toResponse(cita.getMedico() )
        );
        if(cita.getDiagnostico() != null){
            DiagnosticoResponse dig =DiagnosticoResponse.toRespose(cita.getDiagnostico() );
            res.setDiagnostico( dig );
        }
        return res;
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

    public PacienteResponse getPaciente() {
        return paciente;
    }

    public MedicoResponse getMedico() {
        return medico;
    }

    public DiagnosticoResponse getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(DiagnosticoResponse diagnostico) {
        this.diagnostico = diagnostico;
    }
}
