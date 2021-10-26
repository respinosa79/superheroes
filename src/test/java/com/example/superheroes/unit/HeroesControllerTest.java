package com.example.superheroes.unit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.superheroes.controller.HeroesController;
import com.example.superheroes.service.HeroesService;

@SpringBootTest
public class HeroesControllerTest {

	private MockMvc mockMvc;
	
	@MockBean
	private HeroesService heroesService;
	
	@InjectMocks
	private HeroesController heroesController;

	@Test
	public void testAllHeroes() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(heroesController).build();
		this.mockMvc.perform(get("/heroes/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
