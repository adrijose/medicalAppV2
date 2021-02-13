package com.adritec96.apiCites.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "diagnosticos", schema = "public")
public class Diagnostico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "valoracion", nullable = false)
    private String valoracionEspecialista;
    @Column(name = "enfermedad", nullable = false)
    private String enfermedad;
    @OneToOne(mappedBy = "diagnostico")
    private Cita cita;

    ///////////////////////////////////////////////////////

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValoracionEspecialista() {
        return valoracionEspecialista;
    }

    public void setValoracionEspecialista(String valoracionEspecialista) {
        this.valoracionEspecialista = valoracionEspecialista;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
}
