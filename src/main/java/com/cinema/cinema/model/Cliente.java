package com.cinema.cinema.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table (name= "tb_cliente")
public class Cliente {

    @Column
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private long idUsuario;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String senha;

    @Column
    private String username;

}
