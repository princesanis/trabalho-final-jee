package com.javaee.prince.trabalhofinaljee.services;

import java.util.Set;

import com.javaee.prince.trabalhofinaljee.domain.Empresa;

public interface EmpresaService {
	
	Empresa getEmpresaById(String id);

    Set<Empresa> getAllEmpresas();

    Empresa createNewEmpresa(Empresa empresa);
    
    Empresa saveEmpresa(String id, Empresa empresa);
    
    void deleteEmpresaById(String id);

    //Empresa save(Long id, Empresa empresa);

    //Empresa patch(Long id, Empresa empresa);

    //void deleteById(Long id);
}
