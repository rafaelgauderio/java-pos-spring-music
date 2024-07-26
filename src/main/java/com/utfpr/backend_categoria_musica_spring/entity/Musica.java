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
    private Integer duracao;

    @Column(length = 100)
    private String titulo;

    @ManyToOne
    @JoinColumn(name="cod_categoria", nullable = false)
    private Categoria categoria;

}
