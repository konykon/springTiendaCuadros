package com.tiendaCuadros.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiendaCuadros.models.Shop;
import com.tiendaCuadros.persistence.ShopRepository;

@RestController
public class ShopController {

	@Autowired
	private ShopRepository repository;

	@GetMapping(path = "/shops")
	List<Shop> all() {
		return repository.findAll();
	}

	@PostMapping("/shops")
	Shop shop(@RequestBody Shop shop) {
		return repository.save(shop);
	}

	@GetMapping("/shops/{id}")
	Optional<Shop> one(@PathVariable Long id) {
		return repository.findById(id);
	}


}
