package com.adritec96.apiCites.model.entity;

import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "apellidos", nullable = false, length = 70)
    private String apellidos;
    @Column(name="usuario", nullable = false, length = 50)
    private String usuario;
    @Column(name="clave",nullable = false, length = 100)
    private String clave;


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
        Usuario usuario1 = (Usuario) o;
        return id == usuario1.id && Objects.equals(nombre, usuario1.nombre) && Objects.equals(apellidos, usuario1.apellidos) && Objects.equals(usuario, usuario1.usuario) && Objects.equals(clave, usuario1.clave);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos, usuario, clave);
    }

    @Override
    public String toString() {
        return  "  id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", usuario='" + usuario + '\'' +
                ", clave='" + clave + '\'' ;
    }
}
