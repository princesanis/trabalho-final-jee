package com.javaee.prince.trabalhofinaljee.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.prince.trabalhofinaljee.domain.Empresa;
import com.javaee.prince.trabalhofinaljee.repositories.EmpresaRepository;

import com.javaee.prince.trabalhofinaljee.exceptions.ResourceNotFoundException;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	private EmpresaRepository empresaRepository;
	
	public EmpresaServiceImpl(EmpresaRepository empresaRepository) 
	{
		this.empresaRepository = empresaRepository;
	}
	
	@Override
	public Set<Empresa> getAllEmpresas() 
	{
		Set<Empresa> empresas = new HashSet<>();
		
		this.empresaRepository.findAll().iterator().forEachRemaining(empresas::add);
		
		return empresas;
	}
	
	@Override
	public Empresa getEmpresaById(String id) 
	{
		return getById(id);
	}
	
	private Empresa getById(String id) 
	{
		Optional<Empresa> empresaOptional = empresaRepository.findById(id);

        if (!empresaOptional.isPresent()) 
        {
            throw new IllegalArgumentException("Empresa não encontrada pelo valor do ID: " + id.toString() );
        }
        
        return empresaOptional.get();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Empresa createNewEmpresa(Empresa empresa) 
	{
		if(empresaRepository.findByName(empresa.getNome()).isEmpty()) 
		{			
			return empresaRepository.save(empresa);
		}
		else 
		{
			throw new IllegalArgumentException("Já existe uma empresa com este nome cadastrada: " + empresa.getNome());
		}
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Empresa saveEmpresa(String id, Empresa empresa) 
	{

		empresa.setId(id);
	
		Empresa empresaSaved = empresaRepository.save(empresa);
		
		return empresaSaved;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteEmpresaById(String id) 
	{
		empresaRepository.deleteById(id);
	}	

/*	@Override
	public Empresa patch(Long id, Empresa empresa) 
	{
		Empresa savedEmpresa = getById(id);
		
		if(empresa.getNome() != null && !empresa.getNome().isEmpty()) 
		{
			savedEmpresa.setNome(empresa.getNome());
		}
		
		return saveAndReturn(savedEmpresa);
	}*/

/*	@Override
	public void deleteById(Long id) 
	{
		this.empresas.removeIf(empresa -> empresa.getId().equals(id));
	}*/
	
/*	private Empresa saveAndReturn(Empresa empresa) 
	{
		if(empresa.getId() != null) 
		{
			Empresa savedEmpresa = getById(empresa.getId());
			
			this.empresas.set(this.empresas.indexOf(savedEmpresa), empresa);
		} 
		else 
		{
			actualId++;
			
			empresa.setId(actualId);
			
			this.empresas.add(empresa);
		}
        
        return empresa;
    } */
}
