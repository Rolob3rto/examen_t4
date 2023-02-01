package com.roloberto.examen_t4.services;

import java.util.List;

import com.roloberto.examen_t4.model.Grupo;



public interface GruposServices {
    
    public List<Grupo> findAll();

    public Grupo findGrupo(int codigo);

    public void save(Grupo grupo);

    public void update(Grupo grupo);

    public void delete(int codigo);
}
