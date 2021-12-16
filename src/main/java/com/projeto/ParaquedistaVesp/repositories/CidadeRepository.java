package com.projeto.ParaquedistaVesp.repositories;

import com.projeto.ParaquedistaVesp.entities.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
    List<Cidade> findByAtivo(Boolean ativo);
}