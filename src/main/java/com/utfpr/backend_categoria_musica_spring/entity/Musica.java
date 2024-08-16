package com.utfpr.backend_categoria_musica_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "musicas")
@Data
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_musica", nullable = false)
    private Long id;

    @Column(name="duracao_musica")
    private Integer duracao;

    @Column(name = "titulo_musica", length = 100)
    private String titulo;

    //many musics, one category
    @ManyToOne
    @JoinColumn(name="cod_categoria_musica", nullable = false)
    private Categoria categoria;

}
