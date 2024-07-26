package com.utfpr.backend_categoria_musica_spring.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "cod_categoria", nullable = false)
    private Long id;

    @OneToMany
    @Column(name = "desc_categoria", length = 50)
    private String descCategoria;
}
