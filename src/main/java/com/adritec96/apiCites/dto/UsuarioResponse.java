package com.adritec96.apiCites.dto;

import com.adritec96.apiCites.model.entity.Usuario;

import java.util.Objects;


public class UsuarioResponse implements Response {
    private int id;
    private String nombre;
    private String apellidos;
    private String usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioResponse response = (UsuarioResponse) o;
        return id == response.id && Objects.equals(nombre, response.nombre) && Objects.equals(apellidos, response.apellidos) && Objects.equals(usuario, response.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos, usuario);
    }


    @Override
    public String toString() {
        return  " id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", usuario='" + usuario + '\'' ;
    }
}
