package com.adritec96.apiCites.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Paciente extends Usuario implements Serializable {
    @Column(name ="nns", length = 50, nullable = false)
    private String nns;
    @Column(name = "numTarjeta", nullable = false)
    private String numTarjeta;
    @Column(name = "telefono", nullable = false)
    private String telefono;
    @Column(name = "direccion", nullable = false)
    private String direccion;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "pacientes")
    private List<Medico> medicos;

    @OneToMany(mappedBy = "paciente",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cita> citas;

    /////////////////////////////////////////////////////////////////////////////////

    public Paciente(){}
    public Paciente(String nombre, String apellidos, String usuario, String clave, String nns, String numTarjeta, String telefono, String direccion, List<Medico> medicos, List<Cita> citas) {
        super(nombre, apellidos, usuario, clave);
        this.nns = nns;
        this.numTarjeta = numTarjeta;
        this.telefono = telefono;
        this.direccion = direccion;
        this.medicos = medicos;
        this.citas = citas;
    }

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

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }
}
