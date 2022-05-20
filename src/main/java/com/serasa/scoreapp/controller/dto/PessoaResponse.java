package com.serasa.scoreapp.controller.dto;

import com.serasa.scoreapp.entity.Pessoa;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaResponse {
    private String nome;
    private String cidade;
    private String estado;
    private String scoreDescricao;

    public static PessoaResponse convertToPessoaResponse(Pessoa pessoa) {
        return PessoaResponse.builder()
                .nome(pessoa.getNome())
                .cidade(pessoa.getCidade())
                .estado(pessoa.getEstado())
                .scoreDescricao(pessoa.getScoreDescricao())
                .build();
    }
}
