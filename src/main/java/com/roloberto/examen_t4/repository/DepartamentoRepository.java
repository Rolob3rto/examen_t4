package com.rolob3rto.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rolob3rto.springprojects.seguridad.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
    
}
