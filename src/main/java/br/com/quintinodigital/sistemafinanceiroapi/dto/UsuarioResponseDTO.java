package br.com.quintinodigital.sistemafinanceiroapi.dto;

import java.io.Serializable;

public class UsuarioResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	private String nome;
	
	private String identificador;
	
	private String papel;
	
	public UsuarioResponseDTO() { }

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

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}
	
}
