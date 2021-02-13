package com.adritec96.apiCites.dto;

import com.adritec96.apiCites.model.Usuario;


public class UsuarioResponse implements Response {
    private int id;
    private String nombre;
    private String apellidos;
    private String usuario;

    public UsuarioResponse(int id, String nombre, String apellidos, String usuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
    }

    public static UsuarioResponse formAggregate(Usuario usuario){
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellidos(),
                usuario.getUsuario()
        );
    }

    public int getId() {
        return id;
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


}
