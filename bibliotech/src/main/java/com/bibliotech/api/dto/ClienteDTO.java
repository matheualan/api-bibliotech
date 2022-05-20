package com.bibliotech.api.dto;

import com.bibliotech.api.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    @NotBlank
    @Size(min = 3, max = 80)
    private String name;

    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;

    @NotBlank
    private Endereco endereco;

//    @NotBlank
//    @Size(min = 8, max = 8)
//    private String cep;

//    public ClienteDTO(Cliente cliente) {
//        name = getName();
//        cpf = getCpf();
//        cep = getCep();
//    }
}
