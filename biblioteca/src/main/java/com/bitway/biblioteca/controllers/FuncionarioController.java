package com.bitway.biblioteca.controllers;

import com.bitway.biblioteca.dto.FuncionarioDTO;
import com.bitway.biblioteca.entities.Funcionario;
import com.bitway.biblioteca.service.FuncionarioService;
import com.bitway.biblioteca.utils.DateUtil;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private DateUtil dateUtil;
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<Page<FuncionarioDTO>> findAll(@Parameter(hidden = true) Pageable pageable) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /GET findAll"));
        return ResponseEntity.ok().body(funcionarioService.findAll(pageable));
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<FuncionarioDTO> findById(@PathVariable(value = "id") Long id) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /GET findById"));
        return ResponseEntity.ok().body(funcionarioService.findById(id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<FuncionarioDTO> save(@RequestBody @Valid Funcionario funcionario) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /POST save"));
        return ResponseEntity.ok().body(funcionarioService.save(funcionario));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<FuncionarioDTO> deleteById(@PathVariable(value = "id") Long id) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /DELETE deleteById"));
        funcionarioService.deleteById(id);
        return ResponseEntity.accepted().build();
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
