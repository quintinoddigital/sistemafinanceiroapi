package br.com.quintinodigital.sistemafinanceiroapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.quintinodigital.sistemafinanceiroapi.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> { 
	
	public Optional<UsuarioModel> findByIdentificador(String identificador);
	
}
