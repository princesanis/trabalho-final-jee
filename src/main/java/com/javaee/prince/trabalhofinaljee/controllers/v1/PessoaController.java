package com.javaee.prince.trabalhofinaljee.controllers.v1;

import java.util.List;

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

import com.javaee.prince.trabalhofinaljee.domain.Pessoa;
import com.javaee.prince.trabalhofinaljee.services.PessoaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Pessoa API")
@RestController
@RequestMapping(PessoaController.BASE_URL)
public class PessoaController {
	
	public static final String BASE_URL = "/api/v1/pessoas";
	
	private final PessoaService pessoaService;
	
    public PessoaController(PessoaService pessoaService) 
    {
        this.pessoaService = pessoaService;
    }
    
    @ApiOperation(value = "Visualizar lista de Pessoas", notes="Esse endpoint irá retornar todas as pessoas")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pessoa> getAll()
    {
        return pessoaService.getAllPessoas();
    }

    @ApiOperation(value = "Buscar empresa por id")
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Pessoa getById(@PathVariable Long id)
    {
        return pessoaService.getById(id);
    }
    
    @ApiOperation(value = "Criar uma nova pessoa")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa create(@RequestBody Pessoa pessoa)
    {
        return pessoaService.createNew(pessoa);
	}
    
    @ApiOperation(value = "Atualizar uma pessoa existente")
    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Pessoa update(@PathVariable Long id, @RequestBody Pessoa pessoa)
    {
        return pessoaService.save(id, pessoa);
    }
    
    @ApiOperation(value = "Atualizar uma propriedade da pessoa")
    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Pessoa patch(@PathVariable Long id, @RequestBody Pessoa pessoa)
    {
        return pessoaService.patch(id, pessoa);
    }
    
    @ApiOperation(value = "Excluir uma pessoa")
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id)
    {
    	pessoaService.deleteById(id);
    }    

}
