package com.roloberto.examen_t4.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.roloberto.examen_t4.model.Grupo;
import com.roloberto.examen_t4.services.GruposServices;

@Controller
@RequestMapping("/grupos")
public class GruposController {

    @Autowired
    GruposServices grupoServices;
     
    @RequestMapping(path = "/list")
    public ModelAndView list(){

        List<Grupo> grupos = grupoServices.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("grupos", grupos);
        modelAndView.setViewName("grupos/list");

        return modelAndView;
    } 
    
    @RequestMapping(path = "/edit")
    public ModelAndView edit(@RequestParam(name = "codigo", required = true) int codigo ){

        ModelAndView modelAndView = new ModelAndView();

        Grupo grupo = grupoServices.findGrupo(codigo);
        modelAndView.addObject("grupo", grupo);
        modelAndView.setViewName("grupos/edit");

        return modelAndView;
    }

    @RequestMapping(path = "/create")
    public ModelAndView create(){

         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("grupo", new Grupo());
         modelAndView.setViewName("grupos/new");

         return modelAndView;
    }

    @RequestMapping(path = "/save")
    public ModelAndView save(Grupo grupo) throws IOException{

        grupoServices.save(grupo);

         ModelAndView modelAndView = new ModelAndView();
        

         modelAndView.setViewName("redirect:edit?codigo=" + grupo.getCodigo());

         return modelAndView;
    }

    @PostMapping(path = "/update")
    public ModelAndView update(Grupo grupo) throws IOException{
        
        grupoServices.update(grupo);
        
         
        ModelAndView modelAndView = new ModelAndView();
        
        modelAndView.setViewName("redirect:edit?codigo=" + grupo.getCodigo());

         return modelAndView;
    }

    @RequestMapping(path = "/delete/{codigo}")
    public ModelAndView delete(@PathVariable(name = "codigo", required = true) int codigo){

        grupoServices.delete(codigo);

         ModelAndView modelAndView = new ModelAndView();
         
         modelAndView.setViewName("redirect:/grupos/list");

         return modelAndView;
    }   


}
