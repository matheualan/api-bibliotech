package com.bibliotech.api.controller;

import com.bibliotech.api.dto.FuncionarioDTO;
import com.bibliotech.api.model.Funcionario;
import com.bibliotech.api.service.FuncionarioService;
import com.bibliotech.api.utils.DateUtil;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private DateUtil dateUtil;

    @PostMapping
    public ResponseEntity<Funcionario> save(@RequestBody @Valid FuncionarioDTO funcionarioDTO) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /POST save"));
        Funcionario funcionario = new Funcionario();
        BeanUtils.copyProperties(funcionarioDTO, funcionario);
        funcionario.setCreateAt(LocalDateTime.now());
        return ResponseEntity.ok().body(funcionarioService.save(funcionario));
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Optional<Funcionario>> getByMatricula(@PathVariable(value = "matricula") String matricula) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /GET getByMatricula"));
        return ResponseEntity.ok().body(funcionarioService.findByMatricula(matricula));
    }

    @GetMapping
    public ResponseEntity<Page<Funcionario>> listAll(@Parameter(hidden = true) Pageable pageable) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /GET listAll"));
        return ResponseEntity.ok().body(funcionarioService.findAll(pageable));
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Funcionario> update(@PathVariable(value = "matricula") String matricula,
                                              @RequestBody @Valid FuncionarioDTO funcionarioDTO) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /PUT update"));
        Optional<Funcionario> funcionarioOpt = funcionarioService.findByMatricula(matricula);
        var funcionario = new Funcionario();
        BeanUtils.copyProperties(funcionarioDTO, funcionario);
        funcionario.setId(funcionarioOpt.get().getId());
        funcionario.setCreateAt(funcionarioOpt.get().getCreateAt());
        return ResponseEntity.ok().body(funcionarioService.save(funcionario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteByMatricula(@PathVariable(value = "id") Long id) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /DELETE deleteByMatricula"));
        funcionarioService.deleteByMatricula(id);
        return ResponseEntity.status(HttpStatus.OK).body("Funcionário deletado com sucesso.");
    }
}
