package com.pratica09.documentos_categorias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratica09.documentos_categorias.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Exemplo de método customizado
    boolean existsByNome(String nome);
}
