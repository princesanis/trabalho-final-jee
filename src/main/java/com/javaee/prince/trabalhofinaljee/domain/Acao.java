package com.javaee.prince.trabalhofinaljee.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Acao {
	
	@Id
	private Long id;
	
	private String nome;
	
	private BigDecimal valorInicial;
	
	private BigDecimal valorAtual;
	
	private Long idEmpresaProprietaria;
	
	private Long idPessoaProprietaria;
	
	private Date dataCompra;
}
