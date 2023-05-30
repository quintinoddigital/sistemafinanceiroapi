package br.com.quintinodigital.sistemafinanceiroapi.dto;

import java.io.Serializable;

public class UsuarioRequestDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	private String identificador;
	
	private String chave;
	
	public UsuarioRequestDTO() { }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}
	
}
