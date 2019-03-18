package com.javaee.prince.trabalhofinaljee.services;

import java.util.List;

import com.javaee.prince.trabalhofinaljee.domain.Empresa;

public interface EmpresaService {
	
	Empresa getById(Long id);

    List<Empresa> getAllEmpresas();

    Empresa createNew(Empresa empresa);

    Empresa save(Long id, Empresa empresa);

    Empresa patch(Long id, Empresa empresa);

    void deleteById(Long id);
}
