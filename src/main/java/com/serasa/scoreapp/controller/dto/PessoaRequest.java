package com.serasa.scoreapp.controller.dto;

import com.serasa.scoreapp.entity.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaRequest {
    private String nome;
    private String telefone;
    private Integer idade;
    private String cidade;
    private String estado;
    private Integer score;

    public static Pessoa convertToPessoa(PessoaRequest pessoaRequest) {
        return Pessoa.builder()
                .nome(pessoaRequest.getNome())
                .telefone(pessoaRequest.getTelefone())
                .idade(pessoaRequest.getIdade())
                .cidade(pessoaRequest.getCidade())
                .estado(pessoaRequest.getEstado())
                .score(pessoaRequest.getScore())
                .build();
    }
}
