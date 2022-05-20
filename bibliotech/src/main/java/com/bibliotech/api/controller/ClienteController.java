package com.bibliotech.api.controller;

import com.bibliotech.api.dto.ClienteDTO;
import com.bibliotech.api.model.Cliente;
import com.bibliotech.api.service.ClienteService;
import com.bibliotech.api.utils.DateUtil;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
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
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private DateUtil dateUtil;

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody ClienteDTO clienteDTO) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /POST save"));
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);
        cliente.setCreateAt(LocalDateTime.now());
        return ResponseEntity.ok().body(clienteService.save(cliente));
    }

//    @GetMapping("/findId/{id}")
//    public ResponseEntity<Optional<Cliente>> findById(@PathVariable(value = "id") Long id) {
//        return ResponseEntity.ok().body(clienteService.findById(id));
//    }

    @GetMapping("/findName/{name}")
    public ResponseEntity<Optional<Cliente>> findByName(@PathVariable(value = "name") String name) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /GET findByName"));
        return ResponseEntity.ok().body(clienteService.findByName(name));
    }

    @GetMapping
    public ResponseEntity<Page<Cliente>> findAll(@Parameter(hidden = true) Pageable pageable) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /GET findAll"));
        return ResponseEntity.ok().body(clienteService.findAll(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable(value = "id") Long id,
                                          @RequestBody @Valid ClienteDTO clienteDTO) {
        log.info(dateUtil.dataFormatada(LocalDateTime.now()).concat(" /PUT update"));
        Optional<Cliente> clienteOpt = clienteService.findById(id);
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);
        cliente.setId(clienteOpt.get().getId());
        cliente.setCreateAt(clienteOpt.get().getCreateAt());
        return ResponseEntity.ok().body(clienteService.save(cliente));
    }

    @PostMapping("/inserirPorCep")
    public ResponseEntity<Cliente> inserirPorCep(@RequestBody @Valid ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);
        cliente.setCreateAt(LocalDateTime.now());
        clienteService.inserirPorCep(cliente);
        return ResponseEntity.ok(cliente);
    }
}
