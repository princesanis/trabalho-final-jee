package com.javaee.prince.trabalhofinaljee.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Empresa {

	@Id
	private String id;
	private int empresaId;
	private String empresaNome;
}
