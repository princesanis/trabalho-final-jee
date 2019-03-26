package com.javaee.prince.trabalhofinaljee.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Acao {
	
	@Id
	private String id;
	private String name;
	private float valorInicial;
	private float valorAtual;
	private int idEmpresa;
	private int idPessoaProprietaria;
	private String dataInicial;
	private String dataVendaAtual;
	
	public Acao(String id, 
				String name, 
				float valorInicial, 
				float valorAtual, 
				int idEmpresa, 
				int idPessoaProprietaria, 
				String dataInicial, 
				String dataVendaAtual) 
	{
		this.id = id;
		this.name = name;
		this.valorInicial = valorInicial;
		this.valorAtual = valorAtual;
		this.idEmpresa = idEmpresa;
		this.idPessoaProprietaria = idPessoaProprietaria;
		this.dataInicial = dataInicial;
		this.dataVendaAtual = dataVendaAtual;
	}
	
	public Acao () {}
}
