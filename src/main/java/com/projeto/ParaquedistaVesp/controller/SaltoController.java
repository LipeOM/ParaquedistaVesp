package com.projeto.ParaquedistaVesp.controller;

import com.projeto.ParaquedistaVesp.entities.Salto;
import com.projeto.ParaquedistaVesp.repositories.SaltoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("salto")
public class SaltoController {
    @Autowired
    private SaltoRepository saltoRepository;

    @GetMapping
    public List<Salto> listar () {
        List<Salto> lista = saltoRepository.findByAtivo(true);
        return lista;
    }

    @GetMapping("/{id}")
    public Salto buscar (@PathVariable int id) {
        Salto salto = saltoRepository.findById(id).get();
        return salto;
    }
}
