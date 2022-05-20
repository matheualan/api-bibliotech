package com.bitway.biblioteca.dto;


import com.bitway.biblioteca.entities.Funcionario;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {

    private String nome;

    private String cpf;

    private Long matricula;

    public FuncionarioDTO(Funcionario funcionario) {
//        idFunc = funcionario.getIdFunc();
        nome = funcionario.getNome();
        cpf = funcionario.getCpf();
//        criadoEm = funcionario.getCriadoEm();
    }


}
