package com.grupo6.buntuconectapp.repository;


import com.grupo6.buntuconectapp.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TemaRepository extends JpaRepository<Tema,Long>{


    public List <Tema> findAllByNomeContainingIgnoreCase(String nome);



}
