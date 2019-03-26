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

import com.javaee.prince.trabalhofinaljee.domain.Acao;
import com.javaee.prince.trabalhofinaljee.services.AcaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Api de consulta, compra e venda de Ações")
@RestController
@RequestMapping(AcaoController.BASE_URL)
public class AcaoController {
	
	public static final String BASE_URL = "/api/v1/acoes";
	
	private final AcaoService acaoService;
	
    public AcaoController(AcaoService acaoService) 
    {
        this.acaoService = acaoService;
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
    
/*    @ApiOperation(value = "Atualizar uma ação existente")
    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Acao updateAcao(@PathVariable String id, @RequestBody Acao acao)
    {
        return acaoService.save(id, acao);
    }*/
    
    @ApiOperation(value = "Comprar uma Ação")
    @PatchMapping({"/{id}/compras"})
    @ResponseStatus(HttpStatus.OK)
    public Acao comprarAcao(@PathVariable String idAcao, @RequestBody Acao acao)
    {
        return acaoService.comprarAcao(idAcao, acao);
    }
    
    @ApiOperation(value = "Vender uma Ação")
    @PatchMapping({"/{id}/vendas"})
    @ResponseStatus(HttpStatus.OK)
    public Acao venderAcao(@PathVariable String idAcao, @RequestBody Acao acao)
    {
        return acaoService.venderAcao(idAcao, acao);
    }
}
