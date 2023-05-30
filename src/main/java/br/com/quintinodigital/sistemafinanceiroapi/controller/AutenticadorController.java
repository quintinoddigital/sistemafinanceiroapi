package br.com.quintinodigital.sistemafinanceiroapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinodigital.sistemafinanceiroapi.dto.AutenticadorResponseDTO;
import br.com.quintinodigital.sistemafinanceiroapi.dto.UsuarioRequestDTO;
import br.com.quintinodigital.sistemafinanceiroapi.service.AutenticadorService;

@RestController
@RequestMapping("/api/autenticador")
public class AutenticadorController {
	
	@Autowired
	private AutenticadorService autenticadorService;
	
	@PostMapping("/registrar")
	public ResponseEntity<AutenticadorResponseDTO> registrarUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
		return ResponseEntity.ok(autenticadorService.registrarUsuario(usuarioRequestDTO));
	}
	
	@PostMapping("/autenticar")
	public ResponseEntity<AutenticadorResponseDTO> autenticarUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
		return ResponseEntity.ok(autenticadorService.autenticarUsuario(usuarioRequestDTO));
	}

}
