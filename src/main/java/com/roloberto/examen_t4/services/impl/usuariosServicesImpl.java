package com.roloberto.examen_t4.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roloberto.examen_t4.model.Usuario;
import com.roloberto.examen_t4.repository.UsuarioRepository;
import com.roloberto.examen_t4.services.UsuariosServices;


@Service
public class usuariosServicesImpl implements UsuariosServices {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findUsuario(int codigo) {
        Optional<Usuario> findById = usuarioRepository.findById(codigo);
        if(findById != null){
            return findById.get();
        } 
        return null;       
    }

    @Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void update(Usuario usuario) {
        usuarioRepository.save(usuario);        
    }

    @Override
    public void delete(int codigo) {
        usuarioRepository.deleteById(codigo);        
    }

}
