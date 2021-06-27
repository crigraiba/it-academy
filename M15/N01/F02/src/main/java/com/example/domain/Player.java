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

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.index.Indexed;

@Entity
@Table(name = "players")
@Document(collection = "players")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false)
	@Field(name = "_id")
	private String id;
	@Column(name = "name", unique = true)
	@Field(name = "name")
	@Indexed(unique = true)
	private String name;
	@Column(name = "datetime", updatable = false)
	@Field(name = "datetime")
	private LocalDate date;
	
	@OneToMany(mappedBy = "player")
	private List<Game> games = new ArrayList<>();
	
	// Mètode constructor:
	public Player() {
	}
	
	// Mètodes setter:
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	// Mètodes getter:
	public String getId() {
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
