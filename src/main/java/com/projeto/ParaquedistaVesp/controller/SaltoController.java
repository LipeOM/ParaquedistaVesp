package com.projeto.ParaquedistaVesp.controller;

import com.projeto.ParaquedistaVesp.Mensagem;
import com.projeto.ParaquedistaVesp.entities.Salto;
import com.projeto.ParaquedistaVesp.repositories.SaltoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Mensagem incluir (@RequestBody Salto salto) {
        salto.setId(0);
        saltoRepository.save(salto);
        saltoRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("Incluido com sucesso");
        return msg;
    }

    @PutMapping
    public Mensagem alterar (@RequestBody Salto salto) {
        saltoRepository.save(salto);
        saltoRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("Alterado com sucesso");
        return msg;
    }

    @DeleteMapping
    public Mensagem deletar (@RequestBody Salto salto) {
        salto.setAtivo(false);
        saltoRepository.save(salto);
        saltoRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("Deletado com sucesso");
        return msg;
    }
}
