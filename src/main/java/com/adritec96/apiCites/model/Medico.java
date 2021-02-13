package com.adritec96.apiCites.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Medico extends Usuario implements Serializable {
    @Column(length = 50, unique = true)
    private String ncol;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "medicoPaciente",
            joinColumns = @JoinColumn(name = "medico_id"),
            inverseJoinColumns = @JoinColumn(name = "paciente_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"medico_id","paciente_id"})
            )
    private List<Paciente> pacientes;

    @OneToMany(mappedBy = "medico",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cita> citas;

    ////////////////////////////////////////////////////////////////////////////////////////

    public String getNcol() {
        return ncol;
    }

    public void setNcol(String ncol) {
        this.ncol = ncol;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }
}
