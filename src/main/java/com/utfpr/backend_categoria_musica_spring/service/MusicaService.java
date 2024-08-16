package com.utfpr.backend_categoria_musica_spring.service;

import com.utfpr.backend_categoria_musica_spring.entity.Musica;
import com.utfpr.backend_categoria_musica_spring.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    @Transactional(readOnly = true)
    public List<Musica> findAllMusics () {
        List<Musica> musicaList = new ArrayList<>();
        musicaList = musicaRepository.findAll();
        return musicaList;
    }
}
