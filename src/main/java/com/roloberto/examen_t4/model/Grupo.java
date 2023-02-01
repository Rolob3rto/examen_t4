package com.roloberto.examen_t4.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Grupo {
    
    @Id
    @GeneratedValue
    private int codigo;

    @Column(unique = true)
    private String nombre;

    public Grupo() {
    }

    public Grupo(int codigo, String nombre) {
        this.nombre = nombre;        
        this.codigo = codigo;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
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
        Grupo other = (Grupo) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }

  
    

    
   
 

    
}

