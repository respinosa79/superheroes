package com.example.superheroes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.superheroes.controller.dto.HeroesDto;
import com.example.superheroes.exception.HeroesRequestException;
import com.example.superheroes.model.Heroes;
import com.example.superheroes.service.HeroesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(EndPointsUtil.HEROES)
@Api(tags = {"Operaciones sobre los héroes"})
public class HeroesController {
	
	@Autowired
	HeroesService heroesService;
	
	@GetMapping
	@ApiOperation(value = "Consulta los héroes.", notes = "Devuelve todos los héroes existentes en BBDD")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Listado de héroes") })
    public List<Heroes> getAll(){
		return heroesService.getAll();
	}
	
	@GetMapping("/{id}")
    public Heroes getById(@PathVariable(value = "id", required = true) long id ){
		return this.heroesService.getById(id);
	}
	
	@GetMapping("/search/{name}")
    public List<Heroes> getBySearch(@PathVariable(value = "name", required = true) String name){
		return heroesService.getByNameWith(name);
	}
	
	@PostMapping
    public Heroes createHeroes(@RequestBody HeroesDto heroesDto){
		try {
			return heroesService.createHeroes(heroesDto);
		} catch (HeroesRequestException e) {
			throw e;
		} catch (Exception e) {
			throw new HeroesRequestException("heroe not created");
		}
		
	}
	
	@PutMapping
    public Heroes updateHeroes(@RequestBody HeroesDto heroesDto){
		try {
			return heroesService.updateHeroes(heroesDto);
		} catch (HeroesRequestException e) {
			throw e;
		} catch (Exception e) {
			throw new HeroesRequestException("heroe not updated");
		}
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
    public ResponseEntity<String> updateHeroes(@PathVariable(value = "id", required = true) long id){
		try {
			heroesService.deleteHeroes(id);
			return ResponseEntity.ok().body("heroe deleted");
		} catch (HeroesRequestException e) {
			throw e;
		} catch (Exception e) {
			throw new HeroesRequestException("heroe not deleted");
		}
	}
}
