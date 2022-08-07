package com.eduardo.receitas.dto;

import com.eduardo.receitas.entities.Receita;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceitaDTO {

    private Long id;

    private String userName;

    private String titulo;

    private String conteudo;

    private Byte[] foto;

    public ReceitaDTO() {
    }

    public ReceitaDTO(Long id, String userName, String titulo, String conteudo, Byte[] foto) {
        this.id = id;
        this.userName = userName;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.foto = foto;
    }

    public ReceitaDTO(Receita receita) {
        id = receita.getId();
        userName = receita.getUser().getNome();
        titulo = receita.getTitulo();
        conteudo = receita.getConteudo();
        foto = receita.getFoto();
    }
}
