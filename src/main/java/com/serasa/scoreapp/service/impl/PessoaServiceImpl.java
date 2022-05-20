package com.serasa.scoreapp.service.impl;

import com.serasa.scoreapp.entity.Pessoa;
import com.serasa.scoreapp.repository.PessoaRepository;
import com.serasa.scoreapp.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private PessoaRepository pessoaRepository;


    @Override
    public Pessoa create(Pessoa pessoa) {
        Pessoa registro = pessoa;

       if(registro.getScore() >= 0 && registro.getScore() <= 200) {
           registro.setScoreDescricao("Insuficiente");
       }else if(registro.getScore() >= 201 && registro.getScore() <= 500) {
           registro.setScoreDescricao("Inaceitável");
       }else if(registro.getScore() >= 501 && registro.getScore() <= 700) {
           registro.setScoreDescricao("Aceitável");
       }else if(registro.getScore() >= 701 && registro.getScore() <= 1000) {
           registro.setScoreDescricao("Recomendável");
       }

        registro = this.pessoaRepository.save(pessoa);
        return registro;
    }
}
