package com.javaee.prince.trabalhofinaljee.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.prince.trabalhofinaljee.domain.Pessoa;
import com.javaee.prince.trabalhofinaljee.repositories.PessoaRepository;

@Service
public class PessoaServiceImpl implements PessoaService {

	private PessoaRepository pessoaRepository;
	
	
	public PessoaServiceImpl(PessoaRepository pessoaRepository) 
	{
		this.pessoaRepository = pessoaRepository;
	}	
	
	@Override
	public List<Pessoa> getAllPessoas() 
	{
		return this.pessoaRepository.findAll();
	}
	
	@Override
	public Pessoa getPessoaById(String id) 
	{
		Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);

        if (!pessoaOptional.isPresent()) 
        {
            throw new IllegalArgumentException("Pessoa não encontrada pelo valor do ID: " + id.toString() );
        }
        
        return pessoaOptional.get();
		
		//return this.pessoaRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Pessoa createNewPessoa(Pessoa pessoa) 
	{
		if(pessoaRepository.findByName(pessoa.getName()).isEmpty()) 
		{	
			return pessoaRepository.save(pessoa);
		}
		else 
		{
			throw new IllegalArgumentException("Já existe uma empresa com este nome cadastrada: " + pessoa.getName());
		}		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Pessoa updatePessoa(String id, Pessoa pessoa) 
	{
		pessoa.setId(id);
		
		Pessoa pessoaSaved = pessoaRepository.save(pessoa);
		
		return pessoaSaved;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deletePessoaById(String id) 
	{
		pessoaRepository.deleteById(id);
	}
}
