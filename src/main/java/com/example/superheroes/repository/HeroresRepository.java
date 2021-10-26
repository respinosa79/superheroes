package com.example.superheroes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.superheroes.model.Heroes;

@Repository
public interface HeroresRepository extends JpaRepository<Heroes, Long>{

	List<Heroes> findByNameContainingIgnoreCase(String name);
}
