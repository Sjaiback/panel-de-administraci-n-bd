package com.example.proyectointegral.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ICategoriaDAO extends CrudRepository<Categoria, Long> {
    
    public List<Categoria> findAllByOrderByNombreAsc();


    @Query(value = "SELECT * FROM categorias WHERE cat_nombre LIKE ?1", nativeQuery = true)
    public List<Categoria> buscarConParametro(String param);
}
