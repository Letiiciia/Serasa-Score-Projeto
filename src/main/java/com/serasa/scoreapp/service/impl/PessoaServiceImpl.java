package com.serasa.scoreapp.service.impl;

import com.serasa.scoreapp.controller.dto.PessoaResponse;
import com.serasa.scoreapp.entity.Pessoa;
import com.serasa.scoreapp.repository.PessoaRepository;
import com.serasa.scoreapp.service.PessoaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class PessoaServiceImpl implements PessoaService {

    private PessoaRepository pessoaRepository;

    @Override
    public Pessoa create(Pessoa pessoa) {
        Pessoa registro = pessoa;
        log.info("Iniciando lógica do preenchimento da descrição de score no objeto pessoa [{}]", registro);
        if(pessoa.getScore() >= 0 && pessoa.getScore() <= 1000) {
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
            log.info("Finalizando lógica do preenchimento da descrição de score no objeto pessoa [{}]", registro);
            return registro;
        }else{
           registro.setScoreDescricao("Score inválido. Score minímo 0 e máximo 1000");
            log.info("Problema no input do score [{}]", registro);
           return registro;
        }
    }
    @Override
    public Optional<Pessoa> getById(Integer id) {
        Optional<Pessoa> encontrado = this.pessoaRepository.findById(id);
        return encontrado;
    }
    @Override
    public List<PessoaResponse> listAll() {
       List<Pessoa> pessoas = this.pessoaRepository.findAll();
       List<PessoaResponse> pessoasRetorno = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
           PessoaResponse pessoaResponse = PessoaResponse.convertToPessoaResponse(pessoa);
           pessoasRetorno.add(pessoaResponse);
        }
       return pessoasRetorno;
    }
}
