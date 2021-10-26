package com.example.superheroes.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.superheroes.model.Heroes;
import com.example.superheroes.repository.HeroresRepository;

@DataJpaTest
public class HeroesDataTest {
	
	@Autowired
	HeroresRepository heroresRepository;

	@Test
	public void testSaveHeroes() throws Exception {
		Heroes heroes = Heroes.builder().name("Prueba").build();
		this.heroresRepository.save(heroes);
		
		List<Heroes> findAll = this.heroresRepository.findAll();
		
		assertThat(findAll, not(IsEmptyCollection.empty()));
		assertThat(findAll.size(), is(1));
		assertThat(findAll.get(0).getName(), is("Prueba")); 
	}
}
