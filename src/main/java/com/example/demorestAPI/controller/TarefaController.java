package com.example.demorestAPI.controller;

import java.net.URI;
import java.util.List;

import com.example.demorestAPI.model.Tarefa;
import com.example.demorestAPI.repository.TarefaRepository;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    private final TarefaRepository repository;

    public TarefaController(TarefaRepository repository) {
        this.repository = repository;
    }

    // GET /api/tarefas
    @GetMapping
    public List<Tarefa> findAll() {
        return repository.findAll();
    }

    // GET /api/tarefas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/tarefas
    @PostMapping
    public ResponseEntity<Tarefa> create(@Valid @RequestBody Tarefa tarefa) {
        Tarefa saved = repository.save(tarefa);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).body(saved);
    }

    // PUT /api/tarefas/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Long id, @Valid @RequestBody Tarefa tarefa) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setNome(tarefa.getNome());
                    existing.setDataEntrega(tarefa.getDataEntrega());
                    existing.setResponsavel(tarefa.getResponsavel());
                    Tarefa updated = repository.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/tarefas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build(); 
    }

}


