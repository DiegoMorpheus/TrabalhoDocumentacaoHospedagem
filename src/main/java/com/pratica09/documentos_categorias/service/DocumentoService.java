package com.pratica09.documentos_categorias.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pratica09.documentos_categorias.dto.CategoriaDTO;
import com.pratica09.documentos_categorias.dto.DocumentoDTO;
import com.pratica09.documentos_categorias.model.Categoria;
import com.pratica09.documentos_categorias.model.Documento;
import com.pratica09.documentos_categorias.repository.DocumentoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DocumentoService {

    private final DocumentoRepository repo;
    private final CategoriaService categoriaService;

    public DocumentoService(DocumentoRepository repo, CategoriaService categoriaService) {
        this.repo = repo;
        this.categoriaService = categoriaService;
    }

    // Criar novo documento
    public DocumentoDTO criar(Documento documento) {
        Categoria categoria = categoriaService.buscarEntidade(documento.getCategoria().getId());

        // Verifica duplicata: mesmo título na mesma categoria
        boolean duplicado = repo.findByCategoriaId(categoria.getId()).stream()
            .anyMatch(d -> d.getTitulo().equalsIgnoreCase(documento.getTitulo()));

        if (duplicado) {
            throw new IllegalArgumentException("Já existe um documento com esse título nesta categoria");
        }

        documento.setCategoria(categoria);
        Documento novo = repo.save(documento);
        return toDTO(novo);
    }

    // Listar todos
    public List<DocumentoDTO> listar() {
        return repo.findAll().stream()
                   .map(this::toDTO)
                   .collect(Collectors.toList());
    }

    // Listar por categoria
    public List<DocumentoDTO> listarPorCategoria(long categoriaId) {
        return repo.findByCategoriaId(categoriaId).stream()
                   .map(this::toDTO)
                   .collect(Collectors.toList());
    }

    // Buscar por ID
    public DocumentoDTO buscar(long id) {
        Documento documento = repo.findById(id)
                   .orElseThrow(() -> new EntityNotFoundException("Documento não encontrado"));
        return toDTO(documento);
    }

    // Atualizar
    public DocumentoDTO atualizar(long id, Documento documento) {
        Documento existente = repo.findById(id)
                   .orElseThrow(() -> new EntityNotFoundException("Documento não encontrado"));

        Categoria categoria = categoriaService.buscarEntidade(documento.getCategoria().getId());

        // Verifica duplicata ao atualizar
        boolean duplicado = repo.findByCategoriaId(categoria.getId()).stream()
            .anyMatch(d -> d.getTitulo().equalsIgnoreCase(documento.getTitulo()) && d.getId() != id);

        if (duplicado) {
            throw new IllegalArgumentException("Já existe um documento com esse título nesta categoria");
        }

        existente.setTitulo(documento.getTitulo());
        existente.setConteudo(documento.getConteudo());
        existente.setCategoria(categoria);

        Documento atualizado = repo.save(existente);
        return toDTO(atualizado);
    }

    // Deletar
    public void deletar(long id) {
        Documento documento = repo.findById(id)
                   .orElseThrow(() -> new EntityNotFoundException("Documento não encontrado"));
        repo.delete(documento);
    }

    // Conversão para DTO
    private DocumentoDTO toDTO(Documento documento) {
        CategoriaDTO categoriaDTO = new CategoriaDTO(
            documento.getCategoria().getId(),
            documento.getCategoria().getNome()
        );
        return new DocumentoDTO(
            documento.getId(),
            documento.getTitulo(),
            documento.getConteudo(),
            categoriaDTO
        );
    }

    // Método auxiliar para buscar entidade Categoria (sem converter em DTO)
    public Categoria buscarEntidade(long id) {
        return categoriaService.buscarEntidade(id);
    }
}
