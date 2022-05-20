package com.bitway.biblioteca.service;

import com.bitway.biblioteca.dto.ClienteDTO;
import com.bitway.biblioteca.entities.Cliente;
import com.bitway.biblioteca.repositories.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public ClienteDTO save(Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);
        ClienteDTO clienteDTO = new ClienteDTO();
        BeanUtils.copyProperties(clienteSalvo, clienteDTO);
        return clienteDTO;
    }

    public ClienteDTO findById(Long id) {
        Cliente cliente = clienteRepository.findById(id).get();
        ClienteDTO clienteDTO = new ClienteDTO();
        BeanUtils.copyProperties(cliente, clienteDTO);
        return clienteDTO;
    }

    public ClienteDTO findByNome(String nome) {
        Cliente cliente = clienteRepository.findByNome(nome);
        ClienteDTO clienteDTO = new ClienteDTO();
        BeanUtils.copyProperties(cliente, clienteDTO);
        return clienteDTO;
    }


//    public Page<ClienteDTO> findAll(Pageable pageable) {
//        Page<Cliente> cliente = clienteRepository.findAll(pageable);
//        Page<ClienteDTO> clientesDTO = cliente.map(x -> new ClienteDTO(x));
//        return clientesDTO;
//    }

    public Cliente saveAndUpdate(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Page<Cliente> pageAll(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public Optional<Cliente> getById(Long id) {
        return clienteRepository.findById(id);
    }

}
