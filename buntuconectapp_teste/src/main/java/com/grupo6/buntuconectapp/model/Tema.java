package com.grupo6.buntuconectapp.model;




import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_temas")
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Size(min = 1, max = 100, message = "A descricao precisa conter de 1 a 100 caracteres.")
    private String descricao;


    @Size(min = 4, max = 20, message = "O nome do tema deve conter de 4 a 20 caracteres ")
    @NotBlank(message = "O Nome é obrigatorio !")
    private String nome;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}