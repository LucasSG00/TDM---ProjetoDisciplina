package com.cinema.cinema.repository;

import java.util.List;

import com.cinema.cinema.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    public List <Avaliacao> findAllByIdClienteContainingIgnoreCase(String idCliente);

    public List <Avaliacao> findAllByIdFilmeContainingIgnoreCase(String idFilme);

}