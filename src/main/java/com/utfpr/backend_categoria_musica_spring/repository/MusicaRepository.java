package com.utfpr.backend_categoria_musica_spring.repository;

import com.utfpr.backend_categoria_musica_spring.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicaRepository extends JpaRepository <Musica, Long > {

    // JPQL
    @Query("select mus from Musica mus where titulo = ?1")
    Musica encontraMusicaTitulo(String titulo);

    // usando palavras chaves
    Musica findByTitulo(String titulo);

    //query nativa
    @Query(value="SELECT * " +
            "FROM Musica " +
            "WHERE duracao > ?1", nativeQuery = true)
    List<Musica> listaMusicasComDuracaoMaiorQue(Integer duracao);

    // usando palavras chave
    Musica findFirstByOrderByDuracaoDesc();

    //usando palavras chave
    Musica findFirstByOrderByDuracaoAsc();
}
