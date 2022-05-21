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

import java.util.Optional;

@RestController
@AllArgsConstructor
public class PessoaController implements com.serasa.scoreapp.controller.PessoaController {

    private PessoaService pessoaService;

    private ModelMapper modelMapper;

    @Override
    public ResponseEntity create(PessoaRequest pessoaRequest) {
        try {
            this.pessoaService.create(PessoaRequest.convertToPessoa(pessoaRequest));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }




    }

    @Override
    public ResponseEntity<PessoaResponse> getById(Integer id) {

        try {
            Optional<Pessoa> pessoaEncontrada= this.pessoaService.getById(id);
            PessoaResponse retornoDado = PessoaResponse.convertToPessoaResponse(pessoaEncontrada.get());
            return ResponseEntity.status(HttpStatus.OK).body(retornoDado);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }


}
