package com.adritec96.apiCites.dto;

import com.adritec96.apiCites.model.entity.Cita;

import java.util.Date;

public class CitaResponse implements Response {
    private int id;
    private Date fechaHora;
    private String motivo;
    private PacienteResponse paciente;
    private MedicoResponse medico;
    private DiagnosticoResponse diagnostico = null;

    public CitaResponse(int id, Date fechaHora, String motivo, PacienteResponse paciente, MedicoResponse medico) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.paciente = paciente;
        this.medico = medico;
    }

    public static CitaResponse toResponse(Cita cita){
        CitaResponse res = new CitaResponse(
                cita.getId(),
                cita.getFechaHora(),
                cita.getMotivo(),
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
