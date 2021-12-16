package com.projeto.ParaquedistaVesp.repositories;

import com.projeto.ParaquedistaVesp.entities.Batalha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BatalhaRepository extends JpaRepository<Batalha, Integer> {
    List<Batalha> findByativo(Boolean ativo);
}
