package com.cinema.cinema.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table (name= "tb_catalogo")
public class Catalogo {

    @Column
    private Long idCliente;

    @Column
    private Long idFilme;

    @Column
    private String status;

}
