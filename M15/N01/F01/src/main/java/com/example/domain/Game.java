package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "games")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false)
	private String id;
	@Column(name = "dice1")
	private int dice1;
	@Column(name = "dice2")
	private int dice2;
	
	@ManyToOne(optional = false) // Clau forana:
	@JoinColumn(name = "player_id", referencedColumnName = "id")
	private Player player;
	
	// Mètode constructor:
	public Game() {
	}
	
	// Mètodes setter:
	public void setId(String id) {
		this.id = id;
	}
	
	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}
	
	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	// Mètodes getter:
	public String getId() {
		return id;
	}
	
	public int getDice1() {
		return dice1;
	}
	
	public int getDice2() {
		return dice2;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public boolean getIsWon() {
		if ((dice1 + dice2) == 7)
			return true; // Victòria
		else
			return false; // Derrota
	}
	
}
