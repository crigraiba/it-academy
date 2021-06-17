package com.example.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name = "players")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false)
	private String id;
	@Column(name = "name")
	private String name;
	@Column(name = "datetime", insertable = false, updatable = false)
	private LocalDate date;
	
	// Mètode constructor:
	public Player(String name) {
		this.name = name;
	}
	
	// Mètodes setter:
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
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

}
