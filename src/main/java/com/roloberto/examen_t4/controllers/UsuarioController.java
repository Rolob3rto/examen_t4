package com.roloberto.examen_t4.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.roloberto.examen_t4.model.Usuario;
import com.roloberto.examen_t4.services.UsuariosServices;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuariosServices usuarioServices;
     
    @RequestMapping(path = "/list")
    public ModelAndView list(){

        List<Usuario> usuarios = usuarioServices.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuarios", usuarios);
        modelAndView.setViewName("usuarios/list");

        return modelAndView;
    } 
    
    @RequestMapping(path = "/edit")
    public ModelAndView edit(@RequestParam(name = "codigo", required = true) int codigo ){

        ModelAndView modelAndView = new ModelAndView();

        Usuario usuario = usuarioServices.findUsuario(codigo);
        modelAndView.addObject("usuario", usuario);
        modelAndView.setViewName("usuarios/edit");

        return modelAndView;
    }

    @RequestMapping(path = "/create")
    public ModelAndView create(){

         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("usuario", new Usuario());
         modelAndView.setViewName("usuarios/new");

         return modelAndView;
    }

    @RequestMapping(path = "/save")
    public ModelAndView save(Usuario usuario) throws IOException{

        usuarioServices.save(usuario);

         ModelAndView modelAndView = new ModelAndView();
        

         modelAndView.setViewName("redirect:edit?codigo=" + usuario.getCodigo());

         return modelAndView;
    }

    @PostMapping(path = "/update")
    public ModelAndView update(Usuario usuario) throws IOException{
        
        usuarioServices.update(usuario);
        
         
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.setViewName("redirect:edit?codigo=" + usuario.getCodigo());

         return modelAndView;
    }

    @RequestMapping(path = "/delete/{codigo}")
    public ModelAndView delete(@PathVariable(name = "codigo", required = true) int codigo){

        usuarioServices.delete(codigo);

         ModelAndView modelAndView = new ModelAndView();
         
         modelAndView.setViewName("redirect:/usuarios/list");

         return modelAndView;
    }   


}
