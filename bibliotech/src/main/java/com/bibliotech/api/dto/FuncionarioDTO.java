package com.bibliotech.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {

    @NotBlank
    @Size(min = 3, max = 80)
    private String name;

    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;

    @NotBlank
    @Size(min = 7, max = 7, message = "Informe uma matrícula com 7 dígitos.")
    private String matricula;

    @NotBlank
    @Size(min = 8, max = 8)
    private String cep;

}
