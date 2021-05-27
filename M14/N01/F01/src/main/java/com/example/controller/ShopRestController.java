package com.example.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.entity.Shop;
import com.example.repository.IShopRepository;

@RestController
@RequestMapping("/shops")
public class ShopRestController {
	
	@Autowired
	private IShopRepository shopRepository;
	
	@GetMapping("/") // GET /shops/ Llistar Shops
	public ResponseEntity<Iterable<Shop>> read() {
		return ResponseEntity.ok(shopRepository.findAll());
	}
	
	@PostMapping("/") // POST /shops/ Crear Shop
	public ResponseEntity<Shop> create() {
		Shop shop = new Shop();
		
		shop.setName("exemple");
		shop.setCapacity(5);
		
		return ResponseEntity.ok(shopRepository.save(shop));
	}
	
}
