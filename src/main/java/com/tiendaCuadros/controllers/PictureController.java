package com.tiendaCuadros.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiendaCuadros.models.Picture;
import com.tiendaCuadros.persistence.PictureRepository;
import com.tiendaCuadros.persistence.ShopRepository;

@RestController
public class PictureController {
	
	@Autowired
	  private ShopRepository shopRepository;
	
	@Autowired
	  private PictureRepository pictureRepository;
	
	@GetMapping("/shops/{shop_id}/pictures")
    public List<Picture> getAllPicturesByShopId(@PathVariable Long shop_id) {
        return pictureRepository.findByShopId(shop_id);
    }

    @PostMapping("/shops/{shop_id}/pictures")
    public Optional<Object> createPicture(@PathVariable Long shop_id, @Valid @RequestBody Picture picture) {
        return shopRepository.findById(shop_id).map(shop -> {
            picture.setShop(shop);
            return pictureRepository.save(picture);
        });
    }


    @DeleteMapping("/shops/{shop_id}/pictures/{id}")
    public Optional<Object> deletePicture(@PathVariable Long shop_id, @PathVariable Long id) {
        return pictureRepository.findByIdAndShopId(id, shop_id).map(picture -> {
            pictureRepository.delete((Picture) picture);
            return ResponseEntity.ok().build();
        });
    }
}
		


