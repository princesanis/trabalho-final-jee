package com.javaee.prince.trabalhofinaljee.controllers.v1;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaee.prince.trabalhofinaljee.domain.Empresa;
import com.javaee.prince.trabalhofinaljee.services.EmpresaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Empresa API")
@RestController
@RequestMapping(EmpresaController.BASE_URL)
public class EmpresaController {
	
	public static final String BASE_URL = "/api/v1/empresas";
	
	private final EmpresaService empresaService;
	
    public EmpresaController(EmpresaService empresaService) 
    {
        this.empresaService = empresaService;
    }
    
    @ApiOperation(value = "Visualizar lista de Empresas", notes="Esse endpoint irá retornar todas as empresas")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<Empresa> getAllEmpresas()
    {
        return empresaService.getAllEmpresas();
    }

    @ApiOperation(value = "Buscar empresa por id")
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Empresa getEmpresaById(@PathVariable String id)
    {
        return empresaService.getEmpresaById(id);
    }
    
    @ApiOperation(value = "Criar uma nova empresa")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empresa createEmpresa(@RequestBody Empresa empresa)
    {
        return empresaService.createNewEmpresa(empresa);
	}
    
    @ApiOperation(value = "Atualizar uma Empresa existente")
    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Empresa updateEmpresa(@PathVariable String id, @RequestBody Empresa empresa)
    {
        return empresaService.saveEmpresa(id, empresa);
    }
    
/*    @ApiOperation(value = "Atualizar uma propriedade da Empresa")
    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Empresa patch(@PathVariable Long id, @RequestBody Empresa empresa)
    {
        return empresaService.patch(id, empresa);
    }*/
    
    @ApiOperation(value = "Excluir uma Empresa")
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmpresa(@PathVariable String id)
    {
    	empresaService.deleteEmpresaById(id);
    }    
}
