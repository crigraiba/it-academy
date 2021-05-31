package com.example.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.ResponseEntity;

import com.example.repository.IShopRepository;
import com.example.repository.IPictureRepository;
import com.example.controller.exception.ResourceNotFoundException;
import com.example.domain.Picture;

@RestController
@RequestMapping("/shops/{id}/pictures")
public class PictureRestController {

	@Autowired
	private IShopRepository shopRepository;
	@Autowired
	private IPictureRepository pictureRepository;
	
	@GetMapping("/") // GET /shops/{id}/pictures/ Llistar Pictures
	public ResponseEntity<Iterable<Picture>> read(@PathVariable int id) {
		return ResponseEntity.ok(pictureRepository.findAllByShopId(id));
	}
	
	@PostMapping("/") // POST /shops/{id}/pictures/ Crear Picture
	@Transactional
	public ResponseEntity<Picture> create(@PathVariable int id) {
		Picture picture = new Picture();
		
		picture.setAuthor("exemple");
		picture.setPrice(10.6);
		picture.setShop(shopRepository
			.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("botiga", id))
		);
		
		return ResponseEntity.ok(pictureRepository.save(picture));
	}
	
	@DeleteMapping("/") // DELETE /shops/{id}/pictures/ Esborrar Pictures
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable int id) {
		pictureRepository.deleteAllByShopId(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
