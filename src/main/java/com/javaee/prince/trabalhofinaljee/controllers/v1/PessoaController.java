package com.javaee.prince.trabalhofinaljee.controllers.v1;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

@Api("Api de cadastro, consulta, atualização e remoção de Pessoas")
@RestController
@RequestMapping(PessoaController.BASE_URL)
public class PessoaController {
	
	public static final String BASE_URL = "/api/v1/pessoas";
	
	private final PessoaService pessoaService;
	
    public PessoaController(PessoaService pessoaService) 
    {
        this.pessoaService = pessoaService;
    }
    
    @ApiOperation(value = "Visualizar lista de pessoas", notes="Esse endpoint irá retornar todas as pessoas")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pessoa> getAll()
    {
        return pessoaService.getAllPessoas();
    } 

    @ApiOperation(value = "Buscar pessoa por id", notes="Esse endpoint irá retornar uma pessoa pelo seu id")
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Pessoa getPessoaById(@PathVariable String id)
    {
        return pessoaService.getPessoaById(id);
    }
    
    @ApiOperation(value = "Criar uma nova pessoa", notes="Esse endpoint irá cadastrar uma nova pessoa")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa create(@RequestBody Pessoa pessoa)
    {
        return pessoaService.createNewPessoa(pessoa);
	}
    
    @ApiOperation(value = "Atualizar uma pessoa por id", notes="Esse endpoint irá atualizar uma pessoa cadastrada")
    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Pessoa update(@PathVariable String id, @RequestBody Pessoa pessoa)
    {
        return pessoaService.updatePessoa(id, pessoa);
    }
    
    @ApiOperation(value = "Excluir uma pessoa por id", notes="Esse endpoint irá remover uma pessoa cadastrada")
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id)
    {
    	pessoaService.deletePessoaById(id);
    }
}
