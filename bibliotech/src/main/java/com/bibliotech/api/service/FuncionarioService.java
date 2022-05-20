package com.bibliotech.api.service;

import com.bibliotech.api.model.Funcionario;
import com.bibliotech.api.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Transactional
    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Optional<Funcionario> findByMatricula(String matricula) {
        return funcionarioRepository.findByMatricula(matricula);
    }

    public Page<Funcionario> findAll(Pageable pageable) {
        return funcionarioRepository.findAll(pageable);
    }

    public void deleteByMatricula(Long id) {
//        funcionarioRepository.deleteByMatricula(matricula);
        funcionarioRepository.deleteById(id);
    }
}
