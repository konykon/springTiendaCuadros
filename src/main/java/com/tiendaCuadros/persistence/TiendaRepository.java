package com.tiendaCuadros.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiendaCuadros.models.Tienda;

public interface TiendaRepository extends JpaRepository<Tienda, Integer> {

}
