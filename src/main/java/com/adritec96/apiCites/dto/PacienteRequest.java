package com.adritec96.apiCites.dto;

import com.adritec96.apiCites.model.Paciente;


public class PacienteRequest extends UsuarioRequest implements Request {
    private String nns;
    private String numTarjeta;
    private String telefono;
    private String direccion;

    public PacienteRequest(String nombre, String apellidos, String usuario, String clave, String nns, String numTarjeta, String telefono, String direccion) {
        super(nombre, apellidos, usuario, clave);
        this.nns = nns;
        this.numTarjeta = numTarjeta;
        this.telefono = telefono;
        this.direccion = direccion;
    }

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
}
