package com.adritec96.apiCites.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "medicos",schema = "public")
public class Medico extends Usuario implements Serializable {
    @Column(name="ncol",length = 50, unique = true)
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

}
