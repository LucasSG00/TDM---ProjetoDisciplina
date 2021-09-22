package com.cinema.cinema.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table (name= "tb_filme")
public class Filme {

    @Column
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private Long idFilme;

    @Column
    private String nome;

    @Column
    private String genero;

    @Column
    private String lancamento;

    @Column
    private String sinopse;

}
