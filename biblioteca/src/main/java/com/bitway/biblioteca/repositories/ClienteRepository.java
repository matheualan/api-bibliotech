package com.bitway.biblioteca.repositories;

import com.bitway.biblioteca.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByNome(String nome);
}
