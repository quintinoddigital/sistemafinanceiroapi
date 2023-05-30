package br.com.quintinodigital.sistemafinanceiroapi.dto;

public class PessoaResponseDTO {
	
	private Long codigo;
	
	private String nome;
	
	private String tipoPessoa;
	
	public PessoaResponseDTO() { }

	public PessoaResponseDTO(Long codigo, String nome, String tipoPessoa) {
		this.codigo = codigo;
		this.nome = nome;
		this.tipoPessoa = tipoPessoa;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

}
