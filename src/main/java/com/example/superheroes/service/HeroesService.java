package com.example.superheroes.service;

import java.util.List;

import com.example.superheroes.controller.dto.HeroesDto;
import com.example.superheroes.model.Heroes;

public interface HeroesService {

	List<Heroes> getAll();
	Heroes getById(long id);
	List<Heroes> getByNameWith(String name);
	Heroes createHeroes(HeroesDto heroresDto);
	Heroes updateHeroes(HeroesDto heroresDto);
	void deleteHeroes(long id);
}
