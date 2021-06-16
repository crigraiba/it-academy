package com.example.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;

import com.example.repository.IShopRepository;
import com.example.repository.IPictureRepository;
import com.example.domain.Picture;
import com.example.domain.Shop;
import com.example.controller.exception.ResourceNotFoundException;
import com.example.controller.exception.ShopCapacityReachedException;

@RestController
@RequestMapping("/shops/{id}/pictures")
public class PictureRestController {

	@Autowired
	private IShopRepository shopRepository;
	@Autowired
	private IPictureRepository pictureRepository;
	
	@GetMapping
	public ResponseEntity<Iterable<Picture>> read(@PathVariable int id) {
		return ResponseEntity.ok(pictureRepository.findAllByShopId(id));
	}
	
	@PostMapping
	public ResponseEntity<Picture> create(@PathVariable int id, @RequestParam String author, @RequestParam double price) {
		// Comprovem que la botiga existeixi:
		Shop shop = shopRepository
			.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("botiga", id));

		// Comprovem que no s'hagi assolit la capacitat de la botiga:
		ArrayList<Picture> pictures = (ArrayList<Picture>) pictureRepository.findAllByShopId(id);
		
		if (shop.getCapacity() == pictures.size())
			throw new ShopCapacityReachedException();
		else {
			Picture picture = new Picture(author, price, shop);
			pictureRepository.save(picture);
		}
		
		return ResponseEntity.ok(null);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> delete(@PathVariable int id) {
		pictureRepository.deleteAllByShopId(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
