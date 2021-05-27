package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "shops")
public class Shop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, insertable = false, updatable = false)
	private int id;
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	@Column(name = "capacity", nullable = false)
	private int capacity;
	
	/*@OneToMany(mappedBy = "shop")
	private List<Picture> pictures;*/
	
	// M�todes constructor:
	public Shop() {
	}
	
	public Shop(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}
	
	// M�todes setter:
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	// M�todes getter:
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
}
