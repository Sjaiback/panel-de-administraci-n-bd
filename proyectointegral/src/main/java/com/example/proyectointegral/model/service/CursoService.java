package com.example.proyectointegral.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectointegral.model.Curso;
import com.example.proyectointegral.model.ICursoDAO;

import jakarta.transaction.Transactional;


@Service
public class CursoService implements ICursoService {

    @Autowired
    private ICursoDAO cursoDAO;

    @Override
    @Transactional
    public String guardarCurso(Curso curso) {
       try {
         cursoDAO.save(curso);
         return "Curso registrado correctamente";
       } catch (Exception e) {
        return "Error al guardar Curso";
       }
    }

    @Override
    public List<Curso> listarCursos() {
     return (List<Curso>)cursoDAO.findAll();
    }
    

    

}
