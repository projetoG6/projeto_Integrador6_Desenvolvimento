package com.grupo6.buntuconectapp.controller;

import com.grupo6.buntuconectapp.model.Tema;
import com.grupo6.buntuconectapp.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


    @RestController
    @RequestMapping("/tema")
    @CrossOrigin( origins = "*", allowedHeaders = "*")
    public class TemaController {



        @Autowired
        private TemaRepository temaRepository;

        @GetMapping
        public ResponseEntity<List<Tema>> getall(){
        return ResponseEntity.ok(temaRepository.findAll());
    }


        @GetMapping("/{id}")
        public ResponseEntity<Tema> getById(@PathVariable Long id){
        return temaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        }
       @GetMapping("/nome/{nome}")
        public ResponseEntity<List<Tema>> getByNome(@PathVariable String nome){
        return ResponseEntity.ok(temaRepository.findAllByNomeContainingIgnoreCase(nome));

       }
       @PostMapping
            public ResponseEntity<Tema>postTema(@PathVariable @RequestBody Tema tema){
            return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));

       }
       @PutMapping
       public ResponseEntity<Tema>putTema(@Valid @RequestBody Tema tema){
            return temaRepository.findById(tema.getId())
                    .map(r ->ResponseEntity.ok().body(temaRepository.save(tema)))
                    .orElse(ResponseEntity.notFound().build());
            }

       @DeleteMapping("/{id}")
       private ResponseEntity<?>deleteTema(@PathVariable Long id){
            return temaRepository.findById(id)
                    .map(r->{temaRepository.deleteById(id);
                        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                    })
                    .orElse(ResponseEntity.notFound().build());

        }

        
}
