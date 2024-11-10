package com.example.proyectointegral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.proyectointegral.model.Curso;
import com.example.proyectointegral.model.service.ICategoriaService;
import com.example.proyectointegral.model.service.ICursoService;

@Controller
@RequestMapping("/curso")
public class CursoController {
    
    @Autowired
    private ICategoriaService categoriaService; // Corrige el nombre del atributo

    @Autowired
    private ICursoService cursoService;

    @RequestMapping("/")
    public String inicio(Model model) {
        Curso curso = new Curso();
        model.addAttribute("curso", curso); // Corrige la sintaxis aquí

        // Cargar categorías a través del servicio
        
        model.addAttribute("listaCategorias", categoriaService.cargarCategoriasOrdenadas());
        model.addAttribute("listaCursos", cursoService.listarCursos());
        
        // Asegúrate de que esta vista exista
        return "curso/inicio"; 
    }


    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(Curso curso, RedirectAttributes redirectAttributes) {
        String rpta = cursoService.guardarCurso(curso);
        redirectAttributes.addFlashAttribute("mensaje", rpta);
        return "redirect:/curso/";
    }
}
