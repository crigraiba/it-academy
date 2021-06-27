package com.example.domain;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

@Entity
@Table(name = "players")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false)
	private int id;
	@Column(name = "name", unique = true)
	private String name;
	@Column(name = "datetime", insertable = false, updatable = false)
	private LocalDate date;
	
	@OneToMany(mappedBy = "player")
	private List<Game> games = new ArrayList<>();
	
	// Mètodes constructors:
	public Player() {
	}
	
	// Mètodes setter:
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// Mètodes getter:
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public int getWinRate() {
		if (games.size() == 0) {
			return -1; // Jugadors amb 0 tirades.
		} else { // games.size() != 0
			int victories = 0;
			
			for (Game game : games)
				if (game.getIsWon())
					victories++;
			
			if (victories > 0)
				return victories*100/games.size();
			else // victories == 0
				return 0;
		}
	}
	
}
