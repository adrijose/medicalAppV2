package com.adritec96.apiCites.dto;

public class UsuarioRequest implements Response {
    private String nombre;
    private String apellidos;
    private String usuario;
    private String clave;

    public UsuarioRequest(String nombre, String apellidos, String usuario, String clave) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }
}
