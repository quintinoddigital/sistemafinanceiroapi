package br.com.quintinodigital.sistemafinanceiroapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinodigital.sistemafinanceiroapi.dto.PessoaResponseDTO;
import br.com.quintinodigital.sistemafinanceiroapi.model.PessoaModel;
import br.com.quintinodigital.sistemafinanceiroapi.service.PessoaService;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping
	public PessoaResponseDTO saveOne(@RequestBody PessoaModel pessoaModel) {
		return this.pessoaService.saveOne(pessoaModel);
	}
	
	@GetMapping
	public List<PessoaResponseDTO> findAll() {
		return this.pessoaService.findAll();
	}
	
	@PutMapping("{codigoPessoa}")
	public PessoaModel updateOne(@PathVariable("codigoPessoa") Long codigoPessoa, @RequestBody PessoaModel pessoaModel) {
		return this.pessoaService.updateOne(codigoPessoa, pessoaModel);
	}
	
	@DeleteMapping("{codigoPessoa}")
	public void deleteOne(@PathVariable("codigoPessoa") Long codigoPessoa) { 
		this.pessoaService.deleteOne(codigoPessoa);
	}
	
	@GetMapping("{nomePessoa}")
	public List<PessoaResponseDTO> recuperarPessoaNome(@PathVariable("nomePessoa") String nome) {
		return this.pessoaService.recuperarPessoaNome(nome);
	}
	
}
