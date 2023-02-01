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

import com.roloberto.examen_t4.model.Permiso;
import com.roloberto.examen_t4.services.PermisosServices;

@Controller
@RequestMapping("/permisos")
public class PermisosController {

    @Autowired
    PermisosServices permisoServices;
     
    @RequestMapping(path = "/list")
    public ModelAndView list(){

        List<Permiso> permisos = permisoServices.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("permisos", permisos);
        modelAndView.setViewName("permisos/list");

        return modelAndView;
    } 
    
    @RequestMapping(path = "/edit")
    public ModelAndView edit(@RequestParam(name = "codigo", required = true) int codigo ){

        ModelAndView modelAndView = new ModelAndView();

        Permiso permiso = permisoServices.findPermiso(codigo);
        modelAndView.addObject("permiso", permiso);
        modelAndView.setViewName("permisos/edit");

        return modelAndView;
    }

    @RequestMapping(path = "/create")
    public ModelAndView create(){

         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("permiso", new Permiso());
         modelAndView.setViewName("permisos/new");

         return modelAndView;
    }

    @RequestMapping(path = "/save")
    public ModelAndView save(Permiso permiso) throws IOException{

        permisoServices.save(permiso);

         ModelAndView modelAndView = new ModelAndView();
        

         modelAndView.setViewName("redirect:edit?codigo=" + permiso.getCodigo());

         return modelAndView;
    }

    @PostMapping(path = "/update")
    public ModelAndView update(Permiso permiso) throws IOException{
        
        permisoServices.update(permiso);
        
         
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.setViewName("redirect:edit?codigo=" + permiso.getCodigo());

         return modelAndView;
    }

    @RequestMapping(path = "/delete/{codigo}")
    public ModelAndView delete(@PathVariable(name = "codigo", required = true) int codigo){

        permisoServices.delete(codigo);

         ModelAndView modelAndView = new ModelAndView();
         
         modelAndView.setViewName("redirect:/permisos/list");

         return modelAndView;
    }   


}
