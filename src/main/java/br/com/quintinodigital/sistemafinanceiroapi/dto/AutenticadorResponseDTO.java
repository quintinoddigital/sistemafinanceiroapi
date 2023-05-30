package br.com.quintinodigital.sistemafinanceiroapi.dto;

import java.io.Serializable;

public class AutenticadorResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String token;
	
	public AutenticadorResponseDTO() { }

	public AutenticadorResponseDTO(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}	
	
}
