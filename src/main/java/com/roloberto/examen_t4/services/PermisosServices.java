package com.roloberto.examen_t4.services;

import java.util.List;

import com.roloberto.examen_t4.model.Permiso;



public interface PermisosServices {
    
    public List<Permiso> findAll();

    public Permiso findPermiso(int codigo);

    public void save(Permiso permiso);

    public void update(Permiso permiso);

    public void delete(int codigo);
}
