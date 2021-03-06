package com.adritec96.apiCites.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "citas",schema = "public")
public class Cita implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora")
    private Date fechaHora;
    @Column(name = "motivo")
    private String motivo;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
    @OneToOne
    @JoinColumn(name = "diagnostico", referencedColumnName = "id")
    private Diagnostico diagnostico;

    ////////////////////////////////////////////////////////////////////


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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cita cita = (Cita) o;
        return id == cita.id && Objects.equals(fechaHora, cita.fechaHora) && Objects.equals(motivo, cita.motivo) && Objects.equals(paciente, cita.paciente) && Objects.equals(medico, cita.medico) && Objects.equals(diagnostico, cita.diagnostico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaHora, motivo, paciente, medico, diagnostico);
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", fechaHora=" + fechaHora +
                ", motivo='" + motivo + '\'' +
                ", paciente=" + paciente +
                ", medico=" + medico +
                ", diagnostico=" + diagnostico +
                '}';
    }
}
