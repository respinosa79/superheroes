package com.example.superheroes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity
@ApiModel(description = "Heroes")
public class Heroes {

	@Id @GeneratedValue
	@ApiModelProperty(value = "Código único que identifica el héroe", required = true)
	private long id;
	
	@Column(unique=true)
	@ApiModelProperty(value = "Nombre del héroe")
	private String name;
}
