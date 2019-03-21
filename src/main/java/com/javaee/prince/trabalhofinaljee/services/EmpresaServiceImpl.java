package com.javaee.prince.trabalhofinaljee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.prince.trabalhofinaljee.domain.Empresa;
import com.javaee.prince.trabalhofinaljee.repositories.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	//private Long actualId = 0L;
	
	private EmpresaRepository empresaRepository;
	
	public EmpresaServiceImpl(EmpresaRepository empresaRepository) 
	{
		this.empresaRepository = empresaRepository;
	}
	
	@Override
	public List<Empresa> getAllEmpresas() 
	{
		return empresaRepository.findAll();
	}
	
	@Override
	public Empresa getEmpresaById(String id) 
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
		if(empresaRepository.findByName(empresa.getEmpresaNome()).isEmpty()) 
		{	
			//actualId++;
			
			//empresa.setEmpresaId(actualId);
			
			return empresaRepository.save(empresa);
		}
		else 
		{
			throw new IllegalArgumentException("Já existe uma empresa com este nome cadastrada: " + empresa.getEmpresaNome());
		}
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Empresa updateEmpresa(String id, Empresa empresa) 
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
}
