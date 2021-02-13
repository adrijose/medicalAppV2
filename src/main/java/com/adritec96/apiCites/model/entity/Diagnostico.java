package com.adritec96.apiCites.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnostico that = (Diagnostico) o;
        return id == that.id && Objects.equals(valoracionEspecialista, that.valoracionEspecialista) && Objects.equals(enfermedad, that.enfermedad) && Objects.equals(cita, that.cita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valoracionEspecialista, enfermedad, cita);
    }

    @Override
    public String toString() {
        return "Diagnostico{" +
                "id=" + id +
                ", valoracionEspecialista='" + valoracionEspecialista + '\'' +
                ", enfermedad='" + enfermedad + '\'' +
                ", cita=" + cita +
                '}';
    }
}
