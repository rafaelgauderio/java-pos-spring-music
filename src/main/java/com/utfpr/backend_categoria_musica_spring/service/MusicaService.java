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

    public Musica findMusica(String titulo) {
        return musicaRepository.encontraMusicaTitulo(titulo);
    }

    public Musica findMusicaByKeyWord(String titulo) {
        return musicaRepository.findByTitulo(titulo);
    }

    public List<Musica> listarMusicasComDuracaoMaiorQue (Integer duracao) {
        return musicaRepository.listaMusicasComDuracaoMaiorQue(duracao);
    }

    // using key word
    public Musica findFirstMusicWithGreaterDuration() {
        return musicaRepository.findFirstByOrderByDuracaoDesc();
    }

    public Musica findFirstMusicaWithShorterDuration () {
        return musicaRepository.findFirstByOrderByDuracaoAsc();
    }


}
