package com.bitway.biblioteca.service;

import com.bitway.biblioteca.dto.FuncionarioDTO;
import com.bitway.biblioteca.entities.Funcionario;
import com.bitway.biblioteca.repositories.FuncionarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Page<FuncionarioDTO> findAll(Pageable pageable) {
        Page<Funcionario> page = funcionarioRepository.findAll(pageable);
        Page<FuncionarioDTO> pageDTO = page.map(x -> new FuncionarioDTO(x));
        return pageDTO;
    }

    public FuncionarioDTO findById(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).get();
        return new FuncionarioDTO(funcionario);
    }

    @Transactional(readOnly = true)
    public FuncionarioDTO save(Funcionario funcionario) {
        Funcionario funcSalvo = funcionarioRepository.save(funcionario);
        FuncionarioDTO funcDTO = new FuncionarioDTO();
//        funcDTO.setIdFunc(funcSalvo.getIdFunc());
//        funcDTO.setCriadoEm(funcSalvo.getCriadoEm());
        BeanUtils.copyProperties(funcSalvo, funcDTO);
        return funcDTO;
    }

//    @Transactional(readOnly = true)
    public void deleteById(Long id) {
        funcionarioRepository.deleteById(id);
//        return String.format("Funcionário com ID %d deletado com sucesso.", id);
    }
}
