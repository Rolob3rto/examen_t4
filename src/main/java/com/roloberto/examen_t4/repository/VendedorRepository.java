package com.rolob3rto.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rolob3rto.springprojects.seguridad.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
    
}
