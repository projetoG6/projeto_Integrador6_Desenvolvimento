package com.grupo6.buntuconectapp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name= "tb_usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo nome é obrigatorio !")
    @Size(min = 4, max = 50, message = "O Campo nome deve conter no minimo 4 caracteres e no maximo 50.")
    private String nome;

    @NotBlank(message = "Digite seu e-mail !")
    private String usuario;

    @NotBlank(message = "O campo senha nao pode estar vazio!")
    @Size(min = 8 , max = 255, message = "A senha precisa conter no minimo 8 caracteres !")
    private String senha;


    private String foto;


    @OneToMany
    @JsonIgnoreProperties("usuario")
    public Postagem postagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
