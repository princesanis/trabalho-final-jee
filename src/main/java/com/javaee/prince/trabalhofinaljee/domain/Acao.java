package com.javaee.prince.trabalhofinaljee.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Acao {
	
	@Id
	private String id;
	private String name;
	private Double valorInicial;
	private Double valorAtual;
	private String idEmpresa;
	private String idPessoaProprietaria;
	private Date dataOperacao;
	private Boolean disponivel;
	
	public Acao () {}
	
	@Override
    public String toString() 
	{
        return String.format("Acao[idPessoaProprietaria=%s, valorInicial='%s', valorAtual='%s']"
        		, idPessoaProprietaria, valorInicial, valorAtual);	
    }
}
