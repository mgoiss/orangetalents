package com.vobidu.orangetalents.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vobidu.orangetalents.services.exceptions.EntityNotFoundException;


@ControllerAdvice //Controller Advice - Ele vai capturar e tratar todas as exceptions
public class ResourceExceptionHandler {
	
	//HttpServletRequest - Tem as informações da requisição 
	@ExceptionHandler(EntityNotFoundException.class) //Definindo o tipo de exceção que ele vai capiturar
	public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
		//Instanciando o erro
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Resource not found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
