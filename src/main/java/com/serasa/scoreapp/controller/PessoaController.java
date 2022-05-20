package com.serasa.scoreapp.controller;

import com.serasa.scoreapp.controller.dto.PessoaRequest;
import com.serasa.scoreapp.controller.dto.PessoaResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@RequestMapping("/pessoa")
public interface PessoaController {

    @PostMapping
    public ResponseEntity<PessoaResponse> create(@RequestBody PessoaRequest pessoaRequest);
}
