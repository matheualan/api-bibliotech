package com.bibliotech.api.service;

import com.bibliotech.api.model.Cliente;
import com.bibliotech.api.model.Endereco;
import com.bibliotech.api.repository.ClienteRepository;
import com.bibliotech.api.repository.EnderecoRepository;
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

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Optional<Cliente> findByName(String name) {
        return clienteRepository.findByName(name);
    }

    public Page<Cliente> findAll(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public void inserirPorCep(Cliente cliente) {
        salvarClienteVerificandoCep(cliente);
    }

    private void salvarClienteVerificandoCep(Cliente cliente) {
//  Pegar o CEP e verificar se o endereço do cliente existe pelo CEP
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
//  Caso não existir, consumir/integrar a API ViaCEP e persistir no banco de dados
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
    
}
