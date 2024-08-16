package com.utfpr.backend_categoria_musica_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "musica")
@Data
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_musica", nullable = false)
    private Long id;

    @Column(name="duracao")
    private Integer duracao;

    @Column(name = "titulo", length = 100)
    private String titulo;

    //many musics, one category
    @ManyToOne
    @JoinColumn(name="cod_categoria", nullable = false)
    private Categoria categoria;

}
