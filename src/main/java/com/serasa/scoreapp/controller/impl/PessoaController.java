package com.serasa.scoreapp.controller.impl;

import com.serasa.scoreapp.controller.dto.PessoaRequest;
import com.serasa.scoreapp.controller.dto.PessoaResponse;
import com.serasa.scoreapp.entity.Pessoa;
import com.serasa.scoreapp.service.PessoaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PessoaController implements com.serasa.scoreapp.controller.PessoaController {

    private PessoaService pessoaService;

    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<PessoaResponse> create(PessoaRequest pessoaRequest) {
        Pessoa createPessoa = this.pessoaService.create(PessoaRequest.convertToPessoa(pessoaRequest));

        PessoaResponse returnCreation = PessoaResponse.convertToPessoaResponse(createPessoa);

        return ResponseEntity.status(HttpStatus.CREATED).body(returnCreation);

    }
}
