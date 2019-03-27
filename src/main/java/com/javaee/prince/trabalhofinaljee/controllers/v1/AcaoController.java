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

import com.javaee.prince.trabalhofinaljee.domain.Acao;
import com.javaee.prince.trabalhofinaljee.domain.Message;
import com.javaee.prince.trabalhofinaljee.services.AcaoService;
import com.javaee.prince.trabalhofinaljee.services.MessageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Api de consulta, compra e venda de Ações")
@RestController
@RequestMapping(AcaoController.BASE_URL)
public class AcaoController {
	
	public static final String BASE_URL = "/api/v1/acoes";
	
	private final AcaoService acaoService;
	
    public AcaoController(AcaoService acaoService) {
    	
        this.acaoService = acaoService;
        
    }
    
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Set<Acao> getAll() 
	{
		return acaoService.getAll();
	}
    
    @ApiOperation(value = "Buscar ação por id")
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Acao getById(@PathVariable String id)
    {
        return acaoService.getAcaoById(id);
    }
    
    @ApiOperation(value = "Cadastrar uma nova ação")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Acao createAcao(@RequestBody Acao acao)
    {
        return acaoService.createNewAcao(acao);
	}
    
    @ApiOperation(value = "Comprar uma Ação")
    @PostMapping({"/compra"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void comprarAcao(@RequestBody Acao acao)
    //public String comprarAcao(@RequestBody Message message)
    {
        acaoService.comprarAcao(acao);
    }
    
    @ApiOperation(value = "Vender uma Ação")
    @PostMapping({"/venda"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void venderAcao(@RequestBody Acao acao)
    {
        acaoService.venderAcao(acao);
    }
}
