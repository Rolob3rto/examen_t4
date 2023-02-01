package com.rolob3rto.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rolob3rto.springprojects.seguridad.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}
