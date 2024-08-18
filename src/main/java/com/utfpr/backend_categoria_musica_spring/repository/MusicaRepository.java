package com.utfpr.backend_categoria_musica_spring.repository;

import com.utfpr.backend_categoria_musica_spring.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends JpaRepository <Musica, Long > {

    // JPQL
    @Query("select mus from Musica mus where titulo = ?1")
    Musica encontraMusicaTitulo(String titulo);

    // usando palavras chaves
    Musica findByTitulo(String titulo);
}
