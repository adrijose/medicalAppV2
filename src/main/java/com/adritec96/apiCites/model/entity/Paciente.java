package com.adritec96.apiCites.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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


}
