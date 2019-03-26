package com.javaee.prince.trabalhofinaljee.domain;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.javaee.prince.trabalhofinaljee.domain.Empresa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Empresa {

	@Id
	private String id;
	private int empresaId;
	private String name;
	
	public Empresa(String id, int empresaId, String name) {
		
		this.id = id;
		this.empresaId = empresaId;
		this.name = name;
		
	}
	
	public Empresa () {}
	
}
