package com.javaee.prince.trabalhofinaljee.services;

import java.util.List;

import com.javaee.prince.trabalhofinaljee.domain.Pessoa;

public interface PessoaService {
	
	Pessoa getById(Long id);

    List<Pessoa> getAllPessoas();

    Pessoa createNew(Pessoa pessoa);

    Pessoa save(Long id, Pessoa pessoa);

    Pessoa patch(Long id, Pessoa pessoa);

    void deleteById(Long id);
}
