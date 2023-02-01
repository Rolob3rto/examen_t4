package com.roloberto.examen_t4.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Permiso {
    @Id
    @GeneratedValue
    private String codigo;
    
    private String descripcion;

    @ManyToMany
    @JoinTable(
        name = "permiso_usuario"
        , joinColumns={
            @JoinColumn(name="permiso_codigo")
            }
        , inverseJoinColumns={
            @JoinColumn(name="usuario_codigo")
            }
    )
    private List<Usuario> usuarios;

    public Permiso() {
    }

    public Permiso(String codigo, String descripcion) {
        this.descripcion = descripcion;        
        this.codigo = codigo;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        Permiso other = (Permiso) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    
    
   
 

    
}

