package com.javaee.prince.trabalhofinaljee.services;

import java.util.List;

import com.javaee.prince.trabalhofinaljee.domain.Pessoa;

public interface PessoaService {
	
	Pessoa getPessoaById(String id);

    List<Pessoa> getAllPessoas();

    Pessoa createNewPessoa(Pessoa pessoa);

    Pessoa updatePessoa(String id, Pessoa pessoa);

    void deletePessoaById(String id);
}
