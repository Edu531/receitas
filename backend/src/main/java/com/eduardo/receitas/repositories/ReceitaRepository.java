package com.eduardo.receitas.repositories;

import com.eduardo.receitas.entities.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

}
