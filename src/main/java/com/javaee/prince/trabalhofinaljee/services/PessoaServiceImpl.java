package com.javaee.prince.trabalhofinaljee.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.javaee.prince.trabalhofinaljee.domain.Pessoa;
import com.javaee.prince.trabalhofinaljee.exceptions.ResourceNotFoundException;

@Service
public class PessoaServiceImpl implements PessoaService {

	private List<Pessoa> pessoas = new ArrayList<>();
	private Long actualId = 0L;
	
	@Override
	public Pessoa getById(Long id) 
	{
		return this.pessoas
                .stream().filter(pessoa -> pessoa.getId().equals(id))
                .findFirst()
                .orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public List<Pessoa> getAllPessoas() 
	{
		return this.pessoas;
	}

	@Override
	public Pessoa createNew(Pessoa pessoa) 
	{
		return saveAndReturn(pessoa);		
	}

	@Override
	public Pessoa save(Long id, Pessoa pessoa) 
	{
		pessoa.setId(id);
		
        return saveAndReturn(pessoa);
	}

	@Override
	public Pessoa patch(Long id, Pessoa pessoa) 
	{
		Pessoa savedPessoa = getById(id);
		
		if(pessoa.getNome() != null && !pessoa.getNome().isEmpty()) 
		{
			savedPessoa.setNome(pessoa.getNome());
		}
		
		return saveAndReturn(savedPessoa);
	}

	@Override
	public void deleteById(Long id) 
	{
		this.pessoas.removeIf(pessoa -> pessoa.getId().equals(id));
	}
	
	private Pessoa saveAndReturn(Pessoa pessoa) 
	{
		if(pessoa.getId() != null) 
		{
			Pessoa savedPessoa = getById(pessoa.getId());
			
			this.pessoas.set(this.pessoas.indexOf(savedPessoa), pessoa);
		} 
		else 
		{
			actualId++;
			
			pessoa.setId(actualId);
			
			this.pessoas.add(pessoa);
		}
        
        return pessoa;
	}
}
