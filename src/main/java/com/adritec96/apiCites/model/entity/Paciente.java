package com.adritec96.apiCites.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pacientes",schema = "public")
public class Paciente extends Usuario implements Serializable {
    @Column(name ="nns", length = 50, nullable = false)
    private String nns;
    @Column(name = "num_tarjeta", nullable = false)
    private String numTarjeta;
    @Column(name = "telefono", nullable = false)
    private String telefono;
    @Column(name="direccion", nullable = false)
    private String direccion;

    @ManyToMany( mappedBy = "pacientes" )
    private List<Medico> medicos;

    /////////////////////////////////////////////////////////////////////////////////


    public String getNns() {
        return nns;
    }

    public void setNns(String nns) {
        this.nns = nns;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(nns, paciente.nns) && Objects.equals(numTarjeta, paciente.numTarjeta) && Objects.equals(telefono, paciente.telefono) && Objects.equals(direccion, paciente.direccion) && Objects.equals(medicos, paciente.medicos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nns, numTarjeta, telefono, direccion, medicos);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                super.toString() +
                ", nns='" + nns + '\'' +
                ", numTarjeta='" + numTarjeta + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }


}
