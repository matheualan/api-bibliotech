package com.bitway.biblioteca.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_funcionarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFunc;
    private String nome;
    private String cpf;
    private Long matricula;
    private LocalDateTime criadoEm;

}
