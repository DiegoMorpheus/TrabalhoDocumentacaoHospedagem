package com.pratica09.documentos_categorias.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pratica09.documentos_categorias.dto.CategoriaDTO;
import com.pratica09.documentos_categorias.model.Categoria;
import com.pratica09.documentos_categorias.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    // Criar nova categoria
    @PostMapping
    public ResponseEntity<CategoriaDTO> criar(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(service.criar(categoria));
    }

    // Listar todas
    @GetMapping
    public List<CategoriaDTO> listar() {
        return service.listar();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public CategoriaDTO buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    // Atualizar
    @PutMapping("/{id}")
    public CategoriaDTO atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
        return service.atualizar(id, categoria);
    }

    // Deletar
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
