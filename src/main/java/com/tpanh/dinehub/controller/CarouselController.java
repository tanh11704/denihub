package com.tpanh.dinehub.controller;

import com.tpanh.dinehub.entity.Carousel;
import com.tpanh.dinehub.service.impl.ICarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carousels")
public class CarouselController {

    @Autowired
    ICarouselService carouselService;

    @GetMapping
    public ResponseEntity<List<Carousel>> getCarousels() {
        List<Carousel> carousels = carouselService.getAllCarousels();
        return ResponseEntity.ok(carousels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carousel> getCarouselById(@PathVariable Integer id) throws Exception {
        Carousel carousel = carouselService.getCarouselById(id);
        return ResponseEntity.ok(carousel);
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Carousel> createCarousel(@ModelAttribute("file") MultipartFile file) throws Exception {
        Carousel newCarousel = carouselService.createCarousel(file);
        return ResponseEntity.ok(newCarousel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carousel> updateCarousel(@PathVariable Integer id, @ModelAttribute("file") MultipartFile file) throws Exception {
        Carousel updatedCarousel = carouselService.updateCarousel(id, file);
        return ResponseEntity.ok(updatedCarousel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarousel(@PathVariable Integer id) throws Exception {
        carouselService.deleteCarousel(id);
        return ResponseEntity.ok().build();
    }
}
