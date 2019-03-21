package com.javaee.prince.trabalhofinaljee.domain;

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
	private String pessoaNome;
	private String pessoaEmail;
	private String pessoaCpf;
}
