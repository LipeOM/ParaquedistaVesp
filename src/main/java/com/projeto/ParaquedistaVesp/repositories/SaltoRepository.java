package com.projeto.ParaquedistaVesp.repositories;

import com.projeto.ParaquedistaVesp.entities.Salto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaltoRepository extends JpaRepository<Salto, Integer> {
    List<Salto> findByAtivo(Boolean ativo);
}
