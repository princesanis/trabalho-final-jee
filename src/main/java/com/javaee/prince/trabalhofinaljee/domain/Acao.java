package com.javaee.prince.trabalhofinaljee.domain;

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
	private Long acaoId;
	private String acaoNome;
	private float valorInicial;
	private float valorAtual;
	private int idEmpresa;
	private int idPessoaProprietaria;
	private String dataInicial;
	private String dataVendaAtual;
}
