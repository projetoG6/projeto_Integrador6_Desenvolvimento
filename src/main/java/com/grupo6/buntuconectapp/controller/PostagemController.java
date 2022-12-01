package com.grupo6.buntuconectapp.controller;


import com.grupo6.buntuconectapp.model.Postagem;
import com.grupo6.buntuconectapp.repository.PostagemRepository;
import com.grupo6.buntuconectapp.repository.TemaRepository;
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


                @Autowired
                private TemaRepository temaRepository;

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

                @GetMapping ( "/titulo/{titulo}" )
                public  ResponseEntity < List < Postagem >> getByTitulo(@PathVariable  String  titulo ) {
                    return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
                }

                @PostMapping
                public ResponseEntity<Postagem> postPostagem(@Valid @RequestBody Postagem postagem){
                    return temaRepository.findById(postagem.getTema().getId())
                            .map(vpx -> ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem)))
                            .orElse(ResponseEntity.badRequest().build());
                }


                @PutMapping
                public  ResponseEntity<Postagem> putPostagem(@Valid @RequestBody Postagem postagem) {
                    if (postagemRepository.existsById(postagem.getId())) {
                        return temaRepository.findById(postagem.getTema().getId())
                                .map(xpv -> ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem)))
                                .orElse(ResponseEntity.badRequest().build());
                    }
                    return ResponseEntity.notFound().build();
                }

                @DeleteMapping
                public ResponseEntity<?> deletePostagem(@PathVariable Long id){
                    return postagemRepository.findById(id)
                            .map(vpx -> {postagemRepository.deleteById(id);
                            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                            })
                            .orElse(ResponseEntity.notFound().build());
                }








}
