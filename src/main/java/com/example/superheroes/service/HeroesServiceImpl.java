package com.example.superheroes.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.superheroes.annotation.HeroesLogMonitor;
import com.example.superheroes.cache.HeroesCache;
import com.example.superheroes.controller.dto.HeroesDto;
import com.example.superheroes.exception.HeroesRequestException;
import com.example.superheroes.model.Heroes;
import com.example.superheroes.repository.HeroresRepository;

@Service
@Transactional
public class HeroesServiceImpl implements HeroesService{

	@Autowired
	HeroresRepository heroresRepository;
	
	@Autowired
    HeroesCache heroesCache;
	
	@HeroesLogMonitor("getAll")
	@Override
	public List<Heroes> getAll() {
		return this.heroresRepository.findAll();
	}

    @HeroesLogMonitor("getById")
	@Override
	public Heroes getById(long id) {
		Optional<Heroes> optional = this.heroresRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new HeroesRequestException("heroe not found with id: "+id);
		}
	}

    @HeroesLogMonitor("getByNameWith")
	@Override
	public List<Heroes> getByNameWith(String name) {
		return this.heroesCache.getHeroes(name);
	}

    @HeroesLogMonitor("createHeroes")
	@Override
	public Heroes createHeroes(HeroesDto heroresDto) {
		Heroes heroes = Heroes.builder()
				.name(heroresDto.getName())
				.build();
		return this.heroresRepository.save(heroes);
	}

    @HeroesLogMonitor("updateHeroes")
	@Override
	public Heroes updateHeroes(HeroesDto heroresDto) {
		Optional<Heroes> optional = this.heroresRepository.findById(heroresDto.getId());
		if(optional.isPresent()) {
			Heroes heroes = Heroes.builder()
					.id(heroresDto.getId())
					.name(heroresDto.getName())
					.build();
			return this.heroresRepository.save(heroes);
		}else {
			throw new HeroesRequestException("heroe not found with id: "+heroresDto.getId());
		}
	}

    @HeroesLogMonitor("deleteHeroes")
	@Override
	public void deleteHeroes(long id) {
		Optional<Heroes> optional = this.heroresRepository.findById(id);
		if(optional.isPresent()) {
			this.heroresRepository.deleteById(id);
		}else {
			throw new HeroesRequestException("heroe not found with id: "+id);
		}
	}

	
}
