package com.example.proyectointegral.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/panel")
public class PanelController {
    
    @RequestMapping("/")
    private String inicio(){
        return "panel";
    }
}
