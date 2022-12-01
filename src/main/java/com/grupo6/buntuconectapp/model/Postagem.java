package com.grupo6.buntuconectapp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_postagem")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O titulo é obrigatorio ! ")
    @Size(min= 4, max = 20, message = "O titulo deve conter de 4 a 20 caracteres !")
    public String titulo;


    @NotBlank(message = "Nao e possivel enviar uma postagem em branco !")
    @Size(min= 2 , max = 1000, message = "O conteudo do texto deve conter no minimo 2 caracteres e no maximo 1000.")
    public String texto;

    @UpdateTimestamp
    public LocalDateTime data;


    @ManyToOne
    @JsonIgnoreProperties("postagem")
    public Tema tema;

    @ManyToOne
    @JsonIgnoreProperties("postagem")
    public Usuarios usuarios;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
}
