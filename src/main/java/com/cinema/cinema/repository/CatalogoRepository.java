package com.cinema.cinema.repository;

import com.cinema.cinema.model.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatalogoRepository extends JpaRepository<Catalogo, Long> {

    public List<Catalogo> findAllByIdClienteContainingIgnoreCase(String idCliente);

    public List <Catalogo> findAllByIdFilmeContainingIgnoreCase(String idFilme);

}