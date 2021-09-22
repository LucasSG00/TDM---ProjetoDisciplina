package com.cinema.cinema.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table (name= "tb_avaliacao")
public class Avaliacao {

    @Column
    private Long idCliente;

    @Column
    private Long idFilme;

    @Column
    private String comentario;

}
