package com.adritec96.apiCites.dto;

import com.adritec96.apiCites.model.entity.Paciente;

import java.util.Objects;


public class PacienteRequest extends UsuarioRequest implements Request {
    private String nns;
    private String numTarjeta;
    private String telefono;
    private String direccion;


    public Paciente toModel(){
        Paciente paciente = new Paciente();
        paciente.setNombre(super.getNombre());
        paciente.setApellidos(super.getApellidos());
        paciente.setUsuario(super.getUsuario());
        paciente.setClave(super.getClave());
        paciente.setNns(nns);
        paciente.setNumTarjeta(numTarjeta);
        paciente.setTelefono(telefono);
        paciente.setDireccion(direccion);
        return paciente;
    }

    public String getNns() {
        return nns;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNns(String nns) {
        this.nns = nns;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PacienteRequest that = (PacienteRequest) o;
        return Objects.equals(nns, that.nns) && Objects.equals(numTarjeta, that.numTarjeta) && Objects.equals(telefono, that.telefono) && Objects.equals(direccion, that.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nns, numTarjeta, telefono, direccion);
    }

    @Override
    public String toString() {
        return "{" +
                super.toString() +
                ", nns:'" + nns + '\'' +
                ", numTarjeta:'" + numTarjeta + '\'' +
                ", telefono:'" + telefono + '\'' +
                ", direccion:'" + direccion + '\'' +
                '}';
    }
}
