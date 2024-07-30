package com.utfpr.backend_categoria_musica_spring.service;

import com.utfpr.backend_categoria_musica_spring.entity.Categoria;
import com.utfpr.backend_categoria_musica_spring.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAllCategories () {
        return categoriaRepository.findAll();
    }
}
