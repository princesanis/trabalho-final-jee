package com.javaee.prince.trabalhofinaljee.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.javaee.prince.trabalhofinaljee.domain.Empresa;
import com.javaee.prince.trabalhofinaljee.exceptions.ResourceNotFoundException;

@Service
public class EmpresaServiceImpl implements EmpresaService {
	
	private List<Empresa> empresas = new ArrayList<>();
	private Long actualId = 0L;

	@Override
	public Empresa getById(Long id) {
		return this.empresas
                .stream().filter(empresa -> empresa.getId().equals(id))
                .findFirst()
                .orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public List<Empresa> getAllEmpresas() 
	{
        return this.empresas;
	}

	@Override
	public Empresa createNew(Empresa empresa) 
	{
		return saveAndReturn(empresa);
	}

	@Override
	public Empresa save(Long id, Empresa empresa) 
	{
		empresa.setId(id);
		
        return saveAndReturn(empresa);
	}

	@Override
	public Empresa patch(Long id, Empresa empresa) 
	{
		Empresa savedEmpresa = getById(id);
		
		if(empresa.getNome() != null && !empresa.getNome().isEmpty()) 
		{
			savedEmpresa.setNome(empresa.getNome());
		}
		
		return saveAndReturn(savedEmpresa);
	}

	@Override
	public void deleteById(Long id) 
	{
		this.empresas.removeIf(empresa -> empresa.getId().equals(id));
	}
	
	private Empresa saveAndReturn(Empresa empresa) 
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
    }	
}
