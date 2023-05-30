package br.com.quintinodigital.sistemafinanceiroapi.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.quintinodigital.sistemafinanceiroapi.enumeration.PapelEnumeration;

@Entity
@Table(name = "TB_USUARIO")
public class UsuarioModel implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "IDENTIFICADOR", nullable = false)
	private String identificador;
	
	@Column(name = "CHAVE", nullable = false)
	private String chave;
	
	@Column(name = "IMAGEM", nullable = false)
	private byte[] imagem;
	
	@Column(name = "IS_ATIVO", nullable = false)
	private Boolean isAtivo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ID_PAPEL", nullable = false)
	private PapelEnumeration papelEnumeration;
	
	public UsuarioModel() { }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(papelEnumeration.name()));
	}

	@Override
	public String getUsername() {
		return this.identificador;
	}
	
	@Override
	public String getPassword() {
		return this.chave;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public PapelEnumeration getPapelEnumeration() {
		return papelEnumeration;
	}

	public void setPapelEnumeration(PapelEnumeration papelEnumeration) {
		this.papelEnumeration = papelEnumeration;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
