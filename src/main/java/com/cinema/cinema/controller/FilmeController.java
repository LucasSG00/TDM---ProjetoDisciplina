package com.cinema.cinema.controller;

import com.cinema.cinema.model.Filme;
import com.cinema.cinema.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filme")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class FilmeController {

        @Autowired
        private FilmeRepository repository;

        @GetMapping
        public ResponseEntity<List<Filme>> GetAll(){
            return ResponseEntity.ok(repository.findAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity <Filme> getById(@PathVariable Long id) {
            return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
        }

        @GetMapping("/nome/{nome}")
        public ResponseEntity<List<Filme>> getByNome (@PathVariable String nome){
            return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
        }

        @GetMapping("/lancamento/{lancamento}")
        public ResponseEntity<List<Filme>> getByLancamento (@PathVariable String lancamento){
            return ResponseEntity.ok(repository.findAllByLancamentoContainingIgnoreCase(lancamento));
        }

        @GetMapping("/genero/{genero}")
        public ResponseEntity<List<Filme>> getByGenero (@PathVariable String genero){
            return ResponseEntity.ok(repository.findAllByGeneroContainingIgnoreCase(genero));
        }

    }
