package com.adritec96.apiCites.model;

import com.adritec96.apiCites.model.Cita;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Diagnostico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="valoracionEspecialista", nullable = false)
    private String valoracionEspecialista;
    @Column(name = "enfermedad", nullable = false)
    private String enfermedad;
    @OneToOne(mappedBy = "diagnostico", optional = true)
    private Cita cita;

    public Diagnostico(String valoracionEspecialista, String enfermedad) {
        this.valoracionEspecialista = valoracionEspecialista;
        this.enfermedad = enfermedad;
    }

    public Diagnostico() {
    }

    public int getId() {
        return id;
    }

    public String getValoracionEspecialista() {
        return valoracionEspecialista;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
}
