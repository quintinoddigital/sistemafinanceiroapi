package br.com.quintinodigital.sistemafinanceiroapi.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.quintinodigital.sistemafinanceiroapi.dto.HandlerErrorDTO;
import br.com.quintinodigital.sistemafinanceiroapi.utility.DateUtility;

@ControllerAdvice
public class HandlerException {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<HandlerErrorDTO> objectNotFoundException(ObjectNotFoundException objectNotFoundException, HttpServletRequest httpServletRequest) {
		HandlerErrorDTO handlerErrorDTO = new HandlerErrorDTO(HttpStatus.NOT_FOUND.name(), objectNotFoundException.getMessage(), DateUtility.gerarDataFormatada(DateUtility.FORMMAT_DD_MM_AAAA_HH_MM_SS));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(handlerErrorDTO);
	}

}
