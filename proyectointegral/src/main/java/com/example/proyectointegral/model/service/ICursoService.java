package com.example.proyectointegral.model.service;

import java.util.List;

import com.example.proyectointegral.model.Curso;

public interface ICursoService {
    public String guardarCurso(Curso curso);
    public List<Curso> listarCursos();

}
