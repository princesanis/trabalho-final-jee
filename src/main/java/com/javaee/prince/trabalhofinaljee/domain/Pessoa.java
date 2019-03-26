package com.javaee.prince.trabalhofinaljee.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Pessoa {

	@Id
	private String id;
	private int pessoaId;
	private String name;
	private String pessoaEmail;
	private String pessoaCpf;
	
	@DBRef
	private List<Acao> pessoaAcoes;  
	
	public Pessoa (String id, int pessoaId, String name, String pessoaEmail, String pessoaCpf)
	{
		this.id = id;
		this.pessoaId = pessoaId;
		this.name = name;
		this.pessoaEmail = pessoaEmail;
		this.pessoaCpf = pessoaCpf;
		this.pessoaAcoes = new ArrayList<Acao>();
	}
	
	public Pessoa () {}
}
