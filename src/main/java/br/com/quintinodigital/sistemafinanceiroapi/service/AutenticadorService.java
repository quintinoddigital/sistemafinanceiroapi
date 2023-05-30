package br.com.quintinodigital.sistemafinanceiroapi.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.quintinodigital.sistemafinanceiroapi.configuration.JWTServiceConfiguration;
import br.com.quintinodigital.sistemafinanceiroapi.dto.AutenticadorResponseDTO;
import br.com.quintinodigital.sistemafinanceiroapi.dto.UsuarioRequestDTO;
import br.com.quintinodigital.sistemafinanceiroapi.enumeration.PapelEnumeration;
import br.com.quintinodigital.sistemafinanceiroapi.model.UsuarioModel;
import br.com.quintinodigital.sistemafinanceiroapi.repository.UsuarioRepository;

@Service
public class AutenticadorService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private JWTServiceConfiguration jwtServiceConfiguration;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public AutenticadorResponseDTO registrarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
		UsuarioModel usuarioModel = new UsuarioModel();
			usuarioModel.setNome(usuarioRequestDTO.getNome());
			usuarioModel.setIdentificador(usuarioRequestDTO.getIdentificador());
			usuarioModel.setPapelEnumeration(PapelEnumeration.SISTEMA);
			usuarioModel.setIsAtivo(true);
			usuarioModel.setChave(this.passwordEncoder.encode(usuarioRequestDTO.getChave()));
			this.usuarioRepository.save(usuarioModel);
		return new AutenticadorResponseDTO(jwtServiceConfiguration.generateTOKEN(usuarioModel));
	}
	
	public AutenticadorResponseDTO autenticarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
		this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuarioRequestDTO.getIdentificador(), usuarioRequestDTO.getChave()));
		UsuarioModel usuarioModel = this.usuarioRepository.findByIdentificador(usuarioRequestDTO.getIdentificador()).orElseThrow();
		return new AutenticadorResponseDTO(jwtServiceConfiguration.generateTOKEN(usuarioModel));
	}

}
