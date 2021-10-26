package com.example.superheroes.exception;

public class HeroesRequestException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public HeroesRequestException(String message){
		super(message);
	}
	
	public HeroesRequestException(String message, Throwable throwable){
		super(message, throwable);
	}
}
