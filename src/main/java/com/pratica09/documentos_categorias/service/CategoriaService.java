package com.pratica09.documentos_categorias.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pratica09.documentos_categorias.dto.CategoriaDTO;
import com.pratica09.documentos_categorias.model.Categoria;
import com.pratica09.documentos_categorias.repository.CategoriaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriaService {

    private final CategoriaRepository repo;

    public CategoriaService(CategoriaRepository repo) {
        this.repo = repo;
    }

    // Criar nova categoria
    public CategoriaDTO criar(Categoria categoria) {
        if (repo.existsByNome(categoria.getNome())) {
            throw new IllegalArgumentException("Já existe uma categoria com esse nome");
        }
        Categoria nova = repo.save(categoria);
        return toDTO(nova);
    }

    // Listar todas
    public List<CategoriaDTO> listar() {
        return repo.findAll().stream()
                   .map(this::toDTO)
                   .collect(Collectors.toList());
    }

    // Buscar por ID (DTO)
    public CategoriaDTO buscar(long id) {
        Categoria categoria = repo.findById(id)
                   .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));
        return toDTO(categoria);
    }

    // Buscar por ID (ENTIDADE) → usado pelo DocumentoService
    public Categoria buscarEntidade(long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));
    }

    // Atualizar
    public CategoriaDTO atualizar(long id, Categoria categoria) {
        Categoria existente = buscarEntidade(id);

        if (repo.existsByNome(categoria.getNome()) 
            && !existente.getNome().equalsIgnoreCase(categoria.getNome())) {
            throw new IllegalArgumentException("Já existe uma categoria com esse nome");
        }

        existente.setNome(categoria.getNome());
        Categoria atualizada = repo.save(existente);
        return toDTO(atualizada);
    }

    // Deletar
    public void deletar(long id) {
        Categoria categoria = buscarEntidade(id);
        repo.delete(categoria);
    }

    // Conversão para DTO
    private CategoriaDTO toDTO(Categoria categoria) {
        return new CategoriaDTO(categoria.getId(), categoria.getNome());
    }
}
