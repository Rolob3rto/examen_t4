package com.roloberto.examen_t4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roloberto.examen_t4.model.Permiso;

public interface PermisoRepository extends JpaRepository<Permiso, Integer> {
    
}
