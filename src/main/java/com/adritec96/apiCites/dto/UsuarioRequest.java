package com.adritec96.apiCites.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import java.util.Objects;

public class UsuarioRequest implements Response {
    @JsonProperty
    @NotNull
    private String nombre;
    @JsonProperty
    @NotNull
    private String apellidos;
    @JsonProperty
    @NotNull
    private String usuario;
    @JsonProperty
    @NotNull
    private String clave;

    //////////////////////////////////////////////////////

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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioRequest that = (UsuarioRequest) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(apellidos, that.apellidos) && Objects.equals(usuario, that.usuario) && Objects.equals(clave, that.clave);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos, usuario, clave);
    }

    @Override
    public String toString() {
        return  " nombre:'" + nombre + '\'' +
                ", apellidos:'" + apellidos + '\'' +
                ", usuario:'" + usuario + '\'' +
                ", clave:'" + clave + '\'';
    }
}
