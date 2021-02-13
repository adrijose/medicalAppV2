package com.adritec96.apiCites.dto;

import com.adritec96.apiCites.model.entity.Paciente;


public class PacienteResponse extends UsuarioResponse implements Response {
    private String nns;
    private String numTarjeta;
    private String telefono;
    private String direccion;

    public PacienteResponse(int id, String nombre, String apellidos, String usuario, String nns, String numTarjeta, String telefono, String direccion) {
        super(id, nombre, apellidos, usuario);
        this.nns = nns;
        this.numTarjeta = numTarjeta;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public static PacienteResponse toResponse(Paciente paciente){
        return new PacienteResponse(
                paciente.getId(),
                paciente.getNombre(),
                paciente.getApellidos(),
                paciente.getUsuario(),
                paciente.getNns(),
                paciente.getNumTarjeta(),
                paciente.getTelefono(),
                paciente.getDireccion()
        );
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
}
