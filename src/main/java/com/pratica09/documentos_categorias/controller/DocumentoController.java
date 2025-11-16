package com.pratica09.documentos_categorias.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pratica09.documentos_categorias.dto.DocumentoDTO;
import com.pratica09.documentos_categorias.model.Documento;
import com.pratica09.documentos_categorias.service.DocumentoService;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {

    private final DocumentoService service;

    public DocumentoController(DocumentoService service) {
        this.service = service;
    }

    // Criar novo documento
    @PostMapping
    public ResponseEntity<DocumentoDTO> criar(@RequestBody Documento documento) {
        DocumentoDTO novo = service.criar(documento);
        return ResponseEntity.ok(novo);
    }

    // Listar todos ou por categoria
    @GetMapping
    public List<DocumentoDTO> listar(@RequestParam(required = false) Long categoriaId) {
        if (categoriaId != null) {
            return service.listarPorCategoria(categoriaId);
        }
        return service.listar();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public DocumentoDTO buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    // Atualizar
    @PutMapping("/{id}")
    public DocumentoDTO atualizar(@PathVariable Long id, @RequestBody Documento documento) {
        return service.atualizar(id, documento);
    }

    // Deletar
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
