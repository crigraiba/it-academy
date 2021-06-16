package com.example.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.example.domain.Shop;
import com.example.repository.IShopRepository;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/shops")
public class ShopRestController {
	
	@Autowired
	private IShopRepository shopRepository;
	
	@GetMapping
	public String read(Model model) {
		ArrayList<Shop> shops = (ArrayList<Shop>) shopRepository.findAll();
		
		model.addAttribute("h1", "Botigues");
		model.addAttribute("shops", shops);
		model.addAttribute("legend", "Nova botiga");
		model.addAttribute("first", "name");
		model.addAttribute("firstText", "Nom:");
		model.addAttribute("second", "capacity");
		model.addAttribute("secondText", "Capacitat:");
		model.addAttribute("step", 1);
		
		return "index";
	}
	
	@PostMapping
	public String create(@Valid @RequestParam String name, @RequestParam int capacity) {
		Shop shop = new Shop(name, capacity);
		shopRepository.save(shop);
		
		return "redirect:/shops";
	}
	
}
