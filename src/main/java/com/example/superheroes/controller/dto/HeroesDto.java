package com.example.superheroes.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@ApiModel(description = "Heroes DTO")
public class HeroesDto {
	@ApiModelProperty(value = "Código único que identifica el héroe", required = true)
	private long id;
	@ApiModelProperty(value = "Nombre del héroe")
	private String name;
}
