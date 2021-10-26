package com.example.superheroes.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class HeroesException{

	private final String message;
	private final HttpStatus httpStatus;
	private final ZonedDateTime dateTime;
	
}
