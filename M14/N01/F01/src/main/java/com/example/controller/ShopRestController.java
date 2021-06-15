package com.example.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;

import com.example.domain.Shop;
import com.example.repository.IShopRepository;

@RestController
@RequestMapping("/shops")
public class ShopRestController {
	
	@Autowired
	private IShopRepository shopRepository;
	
	@GetMapping
	public ResponseEntity<Iterable<Shop>> read() {
		return ResponseEntity.ok(shopRepository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Shop> create(@RequestParam String name, @RequestParam int capacity) {
		Shop shop = new Shop(name, capacity);
		shopRepository.save(shop);
				
		return ResponseEntity.ok(null);
	}
	
}
