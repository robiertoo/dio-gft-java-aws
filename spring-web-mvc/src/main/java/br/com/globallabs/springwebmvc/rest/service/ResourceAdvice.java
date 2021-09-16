package br.com.globallabs.springwebmvc.rest.service;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.globallabs.springwebmvc.exception.JediNotFoundException;

@ControllerAdvice
public class ResourceAdvice {
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(JediNotFoundException.class)
	public void notFound() {
		
	}
}
