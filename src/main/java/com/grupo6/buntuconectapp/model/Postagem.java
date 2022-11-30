package com.grupo6.buntuconectapp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@TableGenerator(name = "tb_postagem")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O titulo é obrigatorio !")
    @Size(min = 4, max = 20, message ="o titulo nao poder conter menos que 4 caracteres e nao mais que 20." )
    public String titulo;


    @NotBlank(message = "Nao e possivel enviar uma postagem em branco !")
    @Size(min = 2, max = 1000, message = "Voce precisar digitar algo entre 2 e 1000 caracteres.")
    public String texto;


    @UpdateTimestamp
    public LocalDateTime data;

    @ManyToOne
    @JsonIgnoreProperties("postagem")
    public Tema tema;


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
}
