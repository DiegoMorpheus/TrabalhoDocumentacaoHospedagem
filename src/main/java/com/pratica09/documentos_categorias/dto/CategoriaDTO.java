package com.pratica09.documentos_categorias.dto;



public class CategoriaDTO {
    private long id;
    private String nome;

    public CategoriaDTO(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
