package com.example._ProjetoSpring.services.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L; //nao exige ser tratada

	public ObjectNotFoundException (String msg) {
		super(msg);
	}
}
