package com.utfpr.backend_categoria_musica_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categorias")
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "cod_categoria", nullable = false)
    private Long id;

    @Column(name = "desc_categoria", length = 50)
    private String descCategoria;

}
