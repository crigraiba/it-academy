package com.example.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Game;

public interface IGameRepository extends JpaRepository<Game, Integer> {

	ArrayList<Game> findAllByPlayerId(String id);
	
}
