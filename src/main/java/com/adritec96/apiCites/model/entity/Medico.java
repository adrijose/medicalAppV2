package com.adritec96.apiCites.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "medicos",schema = "public")
public class Medico extends Usuario implements Serializable {
    @Column(name="ncol",length = 50, unique = true, nullable = false)
    private String ncol;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "medico_paciente",
            joinColumns = {@JoinColumn(name = "medico_id")},
            inverseJoinColumns = {@JoinColumn(name = "paciente_id")}
    )
    private List<Paciente> pacientes;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Medico medico = (Medico) o;
        return Objects.equals(ncol, medico.ncol) && Objects.equals(pacientes, medico.pacientes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ncol, pacientes);
    }

    @Override
    public String toString() {
        return "Medico{" +
                super.toString() +
                ", ncol='" + ncol + '\'' +
                ", pacientes=" + pacientes +
                '}';
    }
}
