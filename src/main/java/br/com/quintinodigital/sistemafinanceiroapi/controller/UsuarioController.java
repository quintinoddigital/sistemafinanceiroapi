package br.com.quintinodigital.sistemafinanceiroapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinodigital.sistemafinanceiroapi.dto.UsuarioResponseDTO;
import br.com.quintinodigital.sistemafinanceiroapi.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<UsuarioResponseDTO> findAll() {
		return this.usuarioService.findAll();
	}
	
}
