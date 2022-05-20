package com.serasa.scoreapp.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Data
public class Pessoa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String nome;

    @NotNull
    private String telefone;

    @NotNull
    private Integer idade;

    @NotNull
    private String cidade;

    @NotNull
    private String estado;

    @NotNull
    @Size(min = 0, max = 1000)
    private Integer score;

    private String scoreDescricao;



}
