package com.javaee.prince.trabalhofinaljee.services;

import java.util.List;

import com.javaee.prince.trabalhofinaljee.domain.Empresa;

public interface EmpresaService {
	
	Empresa getEmpresaById(String id);

    List<Empresa> getAllEmpresas();

    Empresa createNewEmpresa(Empresa empresa);
    
    Empresa updateEmpresa(String id, Empresa empresa);
    
    void deleteEmpresaById(String id);
}
