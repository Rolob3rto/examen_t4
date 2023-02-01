package com.roloberto.examen_t4.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Usuario {
    
    @Id
    @GeneratedValue
    private String codigo;

    @Column(unique = true)
    private String nombre;

    @Column(unique = true)
    private String email;

    @ManyToOne
    private Grupo grupo;

    @ManyToMany(mappedBy = "usuarios")
    private List<Permiso> permisos;

    public Usuario() {
    }
    
    public Usuario(String codigo, String nombre, String email, Grupo grupo, List<Permiso> permisos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.email = email;
        this.grupo = grupo;
        this.permisos = permisos;
    }

    public Usuario(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    public Usuario(Grupo grupo) {
        this.grupo = grupo;
    }


    public Usuario(Grupo grupo, List<Permiso> permisos) {
        this.grupo = grupo;
        this.permisos = permisos;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }     


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    
}

