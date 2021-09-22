package com.cinema.cinema.controller;

import com.cinema.cinema.model.Catalogo;
import com.cinema.cinema.repository.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogo")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class CatalogoController {

    @Autowired
    private CatalogoRepository repository;

    @GetMapping
    public ResponseEntity<List<Catalogo>> GetAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Catalogo> getById(@PathVariable Long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<Catalogo>> getByIdCliente (@PathVariable String idCliente){
        return ResponseEntity.ok(repository.findAllByIdClienteContainingIgnoreCase(idCliente));
    }

    @GetMapping("/filme/{filme}")
    public ResponseEntity<List<Catalogo>> getByFilme ( @PathVariable String filme){
        return ResponseEntity.ok(repository.findAllByIdFilmeContainingIgnoreCase(filme));
    }

    @PostMapping
    public ResponseEntity<Catalogo> postCatalogo(@RequestBody Catalogo catalogo){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(catalogo));
    }

    @DeleteMapping("/{id}")
    public void deleteCatalogo(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
