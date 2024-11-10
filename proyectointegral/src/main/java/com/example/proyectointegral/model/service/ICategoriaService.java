package com.example.proyectointegral.model.service;

import java.util.List;

import com.example.proyectointegral.model.Categoria;

public interface ICategoriaService {
    public String guardarCategoria(Categoria categoria);
    public List<Categoria>cargarCategorias();
    public Categoria buscarCategoria(Long id);
    public String eliminarCategoria(Long id);
    public List<Categoria> cargarCategoriasFiltradas(String parametro);
    public List<Categoria> cargarCategoriasOrdenadas();

        
}
