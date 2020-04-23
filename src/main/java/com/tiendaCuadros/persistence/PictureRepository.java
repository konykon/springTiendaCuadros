package com.tiendaCuadros.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiendaCuadros.models.Picture;

public interface PictureRepository extends JpaRepository<Picture, Long> {
    List<Picture> findByShopId(Long id);
	Optional<Object> findByIdAndShopId(Long id, Long shop_id);

}
