package com.bibliotech.api.repository;

import com.bibliotech.api.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findByMatricula(String matricula);
    Optional<Funcionario> deleteByMatricula(String matricula);
}
