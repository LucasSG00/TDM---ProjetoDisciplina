package com.cinema.cinema.controller;

import com.cinema.cinema.model.Avaliacao;
import com.cinema.cinema.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacao")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository repository;

    @GetMapping
    public ResponseEntity<List<Avaliacao>> GetAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Avaliacao> getById(@PathVariable Long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<Avaliacao>> getByIdCliente ( @PathVariable String idCliente){
        return ResponseEntity.ok(repository.findAllByIdClienteContainingIgnoreCase(idCliente));
    }

    @GetMapping("/filme/{filme}")
    public ResponseEntity<List<Avaliacao>> getByFilme ( @PathVariable String filme){
        return ResponseEntity.ok(repository.findAllByIdFilmeContainingIgnoreCase(filme));
    }

    @PostMapping
    public ResponseEntity<Avaliacao> postAvaliacao(@RequestBody Avaliacao avaliacao){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(avaliacao));
    }

    @PutMapping
    public ResponseEntity<Avaliacao> putAvaliacao(@RequestBody Avaliacao avaliacao){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(avaliacao));
    }

    @DeleteMapping("/{id}")
    public void deleteAvaliacao(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
