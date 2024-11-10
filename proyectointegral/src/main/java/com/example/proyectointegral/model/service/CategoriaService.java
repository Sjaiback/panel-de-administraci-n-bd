package com.example.proyectointegral.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyectointegral.model.Categoria;
import com.example.proyectointegral.model.ICategoriaDAO;

import jakarta.transaction.Transactional;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private ICategoriaDAO categoriaDAO;

    
    
    @Override
    @Transactional
    public String guardarCategoria(Categoria categoria) {
        try{
            String rpta = "";
            System.out.println("ID: " + categoria.getId());
            if(categoria.getId() == null){
                rpta = "Categoria" + categoria.getNombre() + " insertada correctamente";
            }else{
                rpta = "Categoria" + categoria.getNombre() + " modificada correctamente";
            }
            categoriaDAO.save(categoria);
            return rpta;
        }catch(Exception e){
            return "Error al insertar categoría "+e.getMessage();
        }
    }

    @Override
    public List<Categoria> cargarCategorias() {
        return (List<Categoria>)categoriaDAO.findAll();
    }

    @Override
    public Categoria buscarCategoria(Long id) {
        return categoriaDAO.findById(id).get();
    }

    @Override
    public String eliminarCategoria(Long id) {
        try{
            Categoria cat= buscarCategoria(id);
            categoriaDAO.deleteById(id);
            return "Se elimino la categoria." + cat.getNombre();
        }catch(Exception e){
            return "Error al eliminar categoria " + e.getMessage();
        }
    }

    @Override
    public List<Categoria> cargarCategoriasOrdenadas() {
        return categoriaDAO.findAllByOrderByNombreAsc();
    }

    @Override
    public List<Categoria> cargarCategoriasFiltradas(String parametro) {
        return categoriaDAO.buscarConParametro(parametro);

    }


    
    
}
