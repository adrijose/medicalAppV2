package com.adritec96.apiCites.dto;

import com.adritec96.apiCites.model.entity.Cita;

import java.util.Date;
import java.util.Objects;

public class CitaResponse implements Response {
    private int id;
    private Date fechaHora;
    private String motivo;
    private PacienteResponse paciente;
    private MedicoResponse medico;
    private DiagnosticoResponse diagnostico = null;


    public static CitaResponse toResponse(Cita cita){
        CitaResponse response = new CitaResponse();
        response.setId( cita.getId() );
        response.setFechaHora( cita.getFechaHora() );
        response.setMotivo( cita.getMotivo() );
        response.setMedico( MedicoResponse.toResponse( cita.getMedico() ) );
        response.setPaciente( PacienteResponse.toResponse( cita.getPaciente() ) );
        response.setDiagnostico( cita.getDiagnostico() != null ?
                        DiagnosticoResponse.toRespose(cita.getDiagnostico() ) : null
        );
        return response;
    }

    //////////////////////////////////////////////////////////////////////////


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public PacienteResponse getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteResponse paciente) {
        this.paciente = paciente;
    }

    public MedicoResponse getMedico() {
        return medico;
    }

    public void setMedico(MedicoResponse medico) {
        this.medico = medico;
    }

    public DiagnosticoResponse getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(DiagnosticoResponse diagnostico) {
        this.diagnostico = diagnostico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CitaResponse response = (CitaResponse) o;
        return id == response.id && Objects.equals(fechaHora, response.fechaHora) &&
                Objects.equals(motivo, response.motivo) && Objects.equals(paciente, response.paciente) &&
                Objects.equals(medico, response.medico) && diagnostico.equals(response.diagnostico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaHora, motivo, paciente, medico, diagnostico);
    }
}
