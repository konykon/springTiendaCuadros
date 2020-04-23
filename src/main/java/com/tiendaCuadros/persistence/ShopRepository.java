package com.tiendaCuadros.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiendaCuadros.models.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {


}
