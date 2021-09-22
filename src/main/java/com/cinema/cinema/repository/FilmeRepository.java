package com.cinema.cinema.repository;

import com.cinema.cinema.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

    public List<Filme> findAllByNomeContainingIgnoreCase(String nome);

    public List<Filme> findAllByLancamentoContainingIgnoreCase(String lancamento);

    public List<Filme> findAllByGeneroContainingIgnoreCase(String genero);

}
