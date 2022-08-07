package com.eduardo.receitas.services;

import com.eduardo.receitas.dto.ReceitaDTO;
import com.eduardo.receitas.entities.Receita;
import com.eduardo.receitas.entities.User;
import com.eduardo.receitas.repositories.ReceitaRepository;
import com.eduardo.receitas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<ReceitaDTO> findAll(Pageable pageable) {
        Page<Receita> result = repository.findAll(pageable);
        return result.map(ReceitaDTO::new);
    }

    @Transactional(readOnly = true)
    public ReceitaDTO findById(Long id) {
        Receita result = repository.findById(id).get();
        return new ReceitaDTO(result);
    }

    @Transactional
    public ReceitaDTO saveReceita(Receita receita) {
        User user = userRepository.findByEmail(receita.getUser().getEmail());
        if (user == null) {
            receita.setUser(userRepository.saveAndFlush(receita.getUser()));
        } else {
            receita.setUser(user);
        }

        return new ReceitaDTO(repository.saveAndFlush(receita));
    }
}
