package com.example.proyectointegral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.proyectointegral.model.Categoria;
import com.example.proyectointegral.model.service.ICategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    private ICategoriaService categoriaService;

    @RequestMapping("/")
    public String inicio(Model model){
        Categoria categoria = new Categoria();
        model.addAttribute("categoria", categoria);
        model.addAttribute("listaCategorias", categoriaService.cargarCategorias());
        return "categoria/inicio";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(Categoria categoria, RedirectAttributes redirectAttributes){
        String rpta = categoriaService.guardarCategoria(categoria);
        redirectAttributes.addFlashAttribute("mensaje",rpta);
        return "redirect:/categoria/";
    }

    @RequestMapping("/editar/{id}")
    public String editar(@PathVariable Long id , Model model){
        Categoria categoria = categoriaService.buscarCategoria(id);
        model.addAttribute("categoria", categoria);
        return "categoria/editar";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable (value = "id") Long id , RedirectAttributes redirectAttributes){
        String rpta = categoriaService.eliminarCategoria(id);
        redirectAttributes.addFlashAttribute("eliminar" , rpta);
        return "redirect:/categoria/";
    }

}
