package com.projeto.ParaquedistaVesp.controller;

import com.projeto.ParaquedistaVesp.Mensagem;
import com.projeto.ParaquedistaVesp.entities.Cidade;
import com.projeto.ParaquedistaVesp.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Mensagem incluir (@RequestBody Cidade cidade){
        cidade.setId(0);
        cidadeRepository.save(cidade);
        cidadeRepository.flush();

        Mensagem msg = new Mensagem();
        msg.setMensagem("Ok");
        return msg;
    }

    @PutMapping
    public Mensagem alterar (@RequestBody Cidade cidade){
        cidadeRepository.save(cidade);
        cidadeRepository.flush();

        Mensagem msg = new Mensagem();
        msg.setMensagem("ok");
        return msg;
    }
    @DeleteMapping
    public Mensagem deletar (@RequestBody Cidade cidade){
        cidade.setAtivo(false);
        cidadeRepository.save(cidade);
        cidadeRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("Deletado");
        return msg;
    }


}
