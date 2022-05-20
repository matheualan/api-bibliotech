package com.bitway.biblioteca.dto;

import com.bitway.biblioteca.entities.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

//    private Long idCliente;

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @NotBlank
    private String cep;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime criadoEm;

//    public ClienteDTO(Cliente cliente) {
//        idCliente = cliente.getIdCliente();
//        nome = cliente.getNome();
//        cpf = cliente.getCpf();
//    }


}
