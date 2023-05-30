package br.com.quintinodigital.sistemafinanceiroapi.dto;

import java.io.Serializable;

public class HandlerErrorDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String situacao;
	
	private String mensagem;
	
	private String dataHora;

	public HandlerErrorDTO(String situacao, String mensagem, String dataHora) {
		super();
		this.situacao = situacao;
		this.mensagem = mensagem;
		this.dataHora = dataHora;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

}
