package com.roloberto.examen_t4.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roloberto.examen_t4.model.Permiso;
import com.roloberto.examen_t4.repository.PermisoRepository;
import com.roloberto.examen_t4.services.PermisosServices;


@Service
public class permisosServicesImpl implements PermisosServices {

    @Autowired
    PermisoRepository permisoRepository;

    @Override
    public List<Permiso> findAll() {
        return permisoRepository.findAll();
    }

    @Override
    public Permiso findPermiso(int codigo) {
        Optional<Permiso> findById = permisoRepository.findById(codigo);
        if(findById != null){
            return findById.get();
        } 
        return null;       
    }

    @Override
    public void save(Permiso permiso) {
        permisoRepository.save(permiso);
    }

    @Override
    public void update(Permiso permiso) {
        permisoRepository.save(permiso);        
    }

    @Override
    public void delete(int codigo) {
        permisoRepository.deleteById(codigo);        
    }

}
