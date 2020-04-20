package com.tiendaCuadros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiendaCuadros.models.Tienda;
import com.tiendaCuadros.persistence.TiendaRepository;

@RestController
public class TiendaController {
	
  @Autowired
  private TiendaRepository repository;

  @PostMapping(path="/add") 
  public @ResponseBody String addNewUser (@RequestParam String name
      , @RequestParam int capacity) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    Tienda n = new Tienda(name, capacity);
    n.setName(name);
    n.setCapacity(capacity);
    repository.save(n);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Tienda> getAllUsers() {
    return repository.findAll();
  }
}


