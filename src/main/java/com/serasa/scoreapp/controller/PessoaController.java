package com.serasa.scoreapp.controller;

import com.serasa.scoreapp.controller.dto.PessoaRequest;
import com.serasa.scoreapp.controller.dto.PessoaResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Validated
@RequestMapping("/pessoa")
public interface PessoaController {

    @PostMapping
    public ResponseEntity create(@RequestBody PessoaRequest pessoaRequest);

    @GetMapping("{id}")
    public ResponseEntity<PessoaResponse> getById(@PathVariable Integer id);

    @GetMapping
    public ResponseEntity<List<PessoaResponse>> listAll();

}
