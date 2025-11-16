package com.pratica09.documentos_categorias.dto;

public class DocumentoDTO {
    private long id;
    private String titulo;
    private String conteudo;
    private CategoriaDTO categoria;

    public DocumentoDTO(long id, String titulo, String conteudo, CategoriaDTO categoria) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.categoria = categoria;
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }
}
