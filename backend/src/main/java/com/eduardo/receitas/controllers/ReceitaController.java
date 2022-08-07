package com.eduardo.receitas.controllers;

import com.eduardo.receitas.dto.ReceitaDTO;
import com.eduardo.receitas.entities.Receita;
import com.eduardo.receitas.services.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService service;

    @GetMapping
    public Page<ReceitaDTO> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public ReceitaDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ReceitaDTO saveScore(@RequestBody Receita receita) {
        return service.saveReceita(receita);
    }
}
