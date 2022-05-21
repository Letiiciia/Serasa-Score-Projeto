package com.serasa.scoreapp.service;

import com.serasa.scoreapp.entity.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaService {
    Pessoa create(Pessoa pessoa);

    Optional<Pessoa> getById(Integer id);

    List<Pessoa> listAll();

}
