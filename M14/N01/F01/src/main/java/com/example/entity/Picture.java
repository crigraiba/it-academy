package com.example.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "pictures")
public class Picture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, insertable = false, updatable = false)
	private int id;
	@Column(name = "author", nullable = true, length = 50)
	private String author;
	@Column(name = "price", nullable = false)
	private double price;
	@Column(name = "date", insertable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private LocalDate date;
	
	@ManyToOne(optional = false) // Clau forana:
	@JoinColumn(name = "shop_id", referencedColumnName = "id")
	private Shop shop;
	
	// M�todes constructor:
	public Picture() {
	}
	
	// M�todes setter:
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	// M�todes getter:
	public int getId() {
		return id;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public double getPrice() {
		return price;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public Shop getShop() {
		return shop;
	}
	
}
