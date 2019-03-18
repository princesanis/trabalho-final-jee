package com.javaee.prince.trabalhofinaljee.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Acao {
	
	private Long id;
	
	private String nome;
	
	private BigDecimal valorInicial;
	
	private BigDecimal valorAtual;
	
	private Long idEmpresa;
	
	private Long idPessoa;
	
	private Date dataCompra;
}
