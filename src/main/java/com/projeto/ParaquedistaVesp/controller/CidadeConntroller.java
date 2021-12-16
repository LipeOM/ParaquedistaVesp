package com.projeto.ParaquedistaVesp.controller;

import com.projeto.ParaquedistaVesp.entities.Cidade;
import com.projeto.ParaquedistaVesp.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cidade")
public class CidadeConntroller {

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping
    public List<Cidade> listar(){
        List<Cidade> cidade = cidadeRepository.findByAtivo(true);
        return cidade;
    }
    @GetMapping("/{id}")
    public Cidade buscar(@PathVariable int id){
        Cidade cidade = cidadeRepository.findById(id).get();
        return cidade;
    }

}
