package com.roloberto.examen_t4.services;

import java.util.List;

import com.roloberto.examen_t4.model.Usuario;



public interface UsuariosServices {
    
    public List<Usuario> findAll();

    public Usuario findUsuario(int codigo);

    public void save(Usuario usuario);

    public void update(Usuario usuario);

    public void delete(int codigo);
}
