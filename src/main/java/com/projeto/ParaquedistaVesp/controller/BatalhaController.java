package com.projeto.ParaquedistaVesp.controller;


import com.projeto.ParaquedistaVesp.Mensagem;
import com.projeto.ParaquedistaVesp.entities.Batalha;
import com.projeto.ParaquedistaVesp.repositories.BatalhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("batalha")
public class BatalhaController {

    @Autowired
    private BatalhaRepository batalhaRepository;

    @GetMapping
    public List<Batalha> lista(){
        List<Batalha> lista = batalhaRepository.findByativo(true);
        return lista;
    }

    @GetMapping("/{id}")
    public Batalha buscar(@PathVariable int id){
        Batalha batalha = batalhaRepository.findById(id).get();
        return batalha;
    }

    @PostMapping
    public Mensagem incluir(@RequestBody Batalha batalha){

        batalha.setId(0);
        batalhaRepository.saveAndFlush(batalha);
        Mensagem msg = new Mensagem();
        msg.setMensagem("Inserido!!");
        return msg;
    }
    @PutMapping
    public Mensagem alterar (@RequestBody Batalha batalha){
        batalhaRepository.save(batalha);
        batalhaRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("Alterado!!");
        return msg;
    }
    @DeleteMapping
    public Mensagem deletar (@RequestBody Batalha batalha){
        batalha.setAtivo(false);
        batalhaRepository.save(batalha);
        batalhaRepository.flush();

        Mensagem msg = new Mensagem();
        msg.setMensagem("Deletado");
        return msg;
    }







}
