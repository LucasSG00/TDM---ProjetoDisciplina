package com.cinema.cinema.controller;

import com.cinema.cinema.model.Cliente;
import com.cinema.cinema.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public ResponseEntity<List<Cliente>> GetAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Cliente> getById(@PathVariable Long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> postUsuario(@RequestBody Cliente usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
    }

    @PutMapping
    public ResponseEntity<Cliente> putUsuario(@RequestBody Cliente usuario){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
