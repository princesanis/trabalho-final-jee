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
import com.javaee.prince.trabalhofinaljee.domain.Pessoa;
import com.javaee.prince.trabalhofinaljee.services.AcaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Ação API")
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
    public Acao getById(@PathVariable Long id)
    {
        return acaoService.getById(id);
    }
    
    @ApiOperation(value = "Buscar todas as ações pelo id da pessoa")
    @GetMapping({"/pessoa/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public List<Acao> getAllAcoesByIdPessoa(@PathVariable Long id)
    {
        return acaoService.getAllAcoesByIdPessoa(id);
    }
    
    @ApiOperation(value = "Buscar todas as ações pelo id da empresa")
    @GetMapping({"/empresa/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public List<Acao> getAllAcoesByIdEmpresa(@PathVariable Long id)
    {
        return acaoService.getAllAcoesByIdEmpresa(id);
    }
    
    @ApiOperation(value = "Buscar todas as pessoas que possuem aquela ação pelo seu id")
    @GetMapping({"/{id}/pessoas"})
    @ResponseStatus(HttpStatus.OK)
    public List<Pessoa> getAllPessoasByIdAcao(@PathVariable Long id)
    {
        return acaoService.getAllPessoasByIdAcao(id);
    }
    
    @ApiOperation(value = "Cadastrar uma nova ação")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Acao createAcao(@RequestBody Acao acao)
    {
        return acaoService.createAcao(acao);
	}
    
    @ApiOperation(value = "Atualizar uma ação existente")
    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Acao updateAcao(@PathVariable Long id, @RequestBody Acao acao)
    {
        return acaoService.save(id, acao);
    }
    
    @ApiOperation(value = "Comprar uma Ação")
    @PatchMapping({"/{id}/compra"})
    @ResponseStatus(HttpStatus.OK)
    public Acao comprarAcao(@PathVariable Long id, @RequestBody Acao acao)
    {
        return acaoService.comprarAcao(id, acao);
    }
    
    @ApiOperation(value = "Atualizar uma propriedade da Ação")
    @PatchMapping({"/{id}/venda"})
    @ResponseStatus(HttpStatus.OK)
    public Acao venderAcao(@PathVariable Long id, @RequestBody Acao acao)
    {
        return acaoService.venderAcao(id, acao);
    }
}
