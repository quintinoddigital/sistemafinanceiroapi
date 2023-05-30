package br.com.quintinodigital.sistemafinanceiroapi.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinodigital.sistemafinanceiroapi.dto.UsuarioResponseDTO;
import br.com.quintinodigital.sistemafinanceiroapi.model.UsuarioModel;
import br.com.quintinodigital.sistemafinanceiroapi.repository.UsuarioRepository;

@Service
public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<UsuarioResponseDTO> findAll() {
		List<UsuarioResponseDTO> usuarioResponseDTOList = new ArrayList<>();
		for (UsuarioModel usuarioModel : this.usuarioRepository.findAll()) {
			UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
				usuarioResponseDTO.setCodigo(usuarioModel.getCodigo());
				usuarioResponseDTO.setNome(usuarioModel.getNome());
				usuarioResponseDTO.setIdentificador(usuarioModel.getIdentificador());
				usuarioResponseDTOList.add(usuarioResponseDTO);
		}
		return usuarioResponseDTOList;
	}

}
