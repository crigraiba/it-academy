package com.example.repository.jpa;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Game;

@Repository
public interface IMySQLGameRepository extends JpaRepository<Game, Integer> {

	ArrayList<Game> findAllByPlayerId(int id);
	
}
