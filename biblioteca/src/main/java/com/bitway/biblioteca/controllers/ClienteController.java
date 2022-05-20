package com.bitway.biblioteca.controllers;

import com.bitway.biblioteca.dto.ClienteDTO;
import com.bitway.biblioteca.entities.Cliente;
import com.bitway.biblioteca.service.ClienteService;
import com.bitway.biblioteca.utils.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Log4j2
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private DateUtil dateUtil;
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> save(@RequestBody @Valid Cliente cliente) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /POST save"));
        cliente.setCriadoEm(LocalDateTime.now());
        return ResponseEntity.ok().body(clienteService.save(cliente));
    }

//      PROBLEMA NO RETORNO DO ID E CRIADOEM
//    @GetMapping
//    public ResponseEntity<Page<ClienteDTO>> findAll(Pageable pageable) {
//        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /GET findAll"));
//        return ResponseEntity.ok().body(clienteService.findAll(pageable));
//    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<ClienteDTO> findById(@PathVariable(value = "id") Long id) {
//        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /GET findById"));
//        return ResponseEntity.ok().body(clienteService.findById(id));
//    }

    @GetMapping(value = "/findByName/{nome}")
    public ResponseEntity<ClienteDTO> findByName(@PathVariable(value = "nome") String nome) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /GET findByName"));
        return ResponseEntity.ok().body(clienteService.findByNome(nome));
    }

    @GetMapping
    public ResponseEntity<Page<Cliente>> page(@ParameterObject Pageable pageable) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /GET page"));
        return ResponseEntity.ok().body(clienteService.pageAll(pageable));
    }

//    NÃO ESTÁ ALTERANDO E SIM CRIANDO UM NOVO REGISTRO
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable(value = "id") Long id,
                                             @RequestBody @Valid ClienteDTO clienteDTO) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /PUT update"));
        Cliente cliente = clienteService.getById(id).get();
        Cliente clienteNew = new Cliente();
        BeanUtils.copyProperties(clienteDTO, clienteNew);
        clienteNew.setCriadoEm(cliente.getCriadoEm());
        return ResponseEntity.ok().body(clienteService.saveAndUpdate(clienteNew));
    }

}
