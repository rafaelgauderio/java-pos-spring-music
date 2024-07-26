package com.utfpr.backend_categoria_musica_spring.repository;

import com.utfpr.backend_categoria_musica_spring.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends JpaRepository <Musica, Long > {
}
