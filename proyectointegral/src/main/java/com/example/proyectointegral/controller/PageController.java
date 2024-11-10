
package com.example.proyectointegral.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/cliente")
    public String indexCliente() {
        return "cliente/inicio"; // Retorna el nombre del archivo HTML sin la extensión
    }
}
