package com.example.superheroes.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HeroesExceptionHandler{
	
	@ExceptionHandler(value = {HeroesRequestException.class})
	public ResponseEntity<Object> handleApiRequestException(HeroesRequestException e){
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		HeroesException exception = HeroesException.builder()
									.message(e.getMessage())
									.httpStatus(httpStatus)
									.dateTime(ZonedDateTime.now())
									.build();
		return new ResponseEntity<>(exception, httpStatus);	
	}
}
