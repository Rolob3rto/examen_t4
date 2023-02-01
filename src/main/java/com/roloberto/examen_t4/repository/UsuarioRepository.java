package com.roloberto.examen_t4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roloberto.examen_t4.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
