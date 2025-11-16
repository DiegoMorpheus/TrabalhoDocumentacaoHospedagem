package com.pratica09.documentos_categorias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratica09.documentos_categorias.model.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
    // Exemplo de método customizado
    List<Documento> findByCategoriaId(Long categoriaId);
}
