package com.example.superheroes.cache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.example.superheroes.model.Heroes;
import com.example.superheroes.repository.HeroresRepository;

@Component
public class HeroesCache {

	@Autowired
	HeroresRepository heroresRepository;

    @Cacheable(value = "heroesCache", key = "#name")
    public List<Heroes> getHeroes(String name) {
        return heroresRepository.findByNameContainingIgnoreCase(name);
    }
}
