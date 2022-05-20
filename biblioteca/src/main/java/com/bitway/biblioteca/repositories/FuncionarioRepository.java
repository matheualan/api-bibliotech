package com.bitway.biblioteca.repositories;

import com.bitway.biblioteca.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
