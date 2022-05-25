package com.serasa.scoreapp.controller.impl;

import com.serasa.scoreapp.controller.dto.PessoaRequest;
import com.serasa.scoreapp.controller.dto.PessoaResponse;
import com.serasa.scoreapp.entity.Pessoa;
import com.serasa.scoreapp.service.PessoaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
public class PessoaController implements com.serasa.scoreapp.controller.PessoaController {

    private PessoaService pessoaService;


    @Override
    public ResponseEntity<Pessoa> create(@RequestBody PessoaRequest pessoaRequest) {
        try {
            Pessoa retorno = this.pessoaService.create(PessoaRequest.convertToPessoa(pessoaRequest));
            log.info("Criando um novo registro [{}]", retorno);
            if (retorno.getScoreDescricao() == "Score inválido. Score minímo 0 e máximo 1000") {
                log.info("Score inputado inválido [{}]", retorno);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(retorno);
            } else {
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Override
    public ResponseEntity<PessoaResponse> getById(Integer id) {
        try {
            Optional<Pessoa> pessoaEncontrada = this.pessoaService.getById(id);
            PessoaResponse retornoDado = PessoaResponse.convertToPessoaResponse(pessoaEncontrada.get());
            log.info("Trazendo um registro por id [{}]", pessoaEncontrada.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body(retornoDado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    @Override
    public ResponseEntity<List<PessoaResponse>> listAll() {
        try {
            List<PessoaResponse> pessoasResponse = this.pessoaService.listAll();
            log.info("Trazendo uma lista de registros [{}]", pessoasResponse);
            if (pessoasResponse.isEmpty()) {
                log.info("Lista de registros vazia [{}]", pessoasResponse);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(pessoasResponse);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
