package com.grupo6.buntuconectapp.controller;


import com.grupo6.buntuconectapp.model.Postagem;
import com.grupo6.buntuconectapp.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/postagem")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {


                @Autowired
                private PostagemRepository postagemRepository;

                @GetMapping
                public ResponseEntity<List<Postagem>> getall(){
                    return ResponseEntity.ok(postagemRepository.findAll());
                }

                @GetMapping("/{id}")
                public ResponseEntity<Postagem> getById(@PathVariable Long id){
                    return postagemRepository.findById(id)
                            .map(ResponseEntity:: ok)
                            .orElse(ResponseEntity.notFound().build());
                }
    @ GetMapping ( "/titulo/{titulo}" )
    public  ResponseEntity < List < Postagem >> getByTitulo(@PathVariable  String  titulo ) {
        return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
    }



}
