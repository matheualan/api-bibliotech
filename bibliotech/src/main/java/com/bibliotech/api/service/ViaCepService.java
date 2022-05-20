
package com.bibliotech.api.service;

import com.bibliotech.api.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping(path = "/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);

}

