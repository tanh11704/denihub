package com.tpanh.dinehub.service.impl;

import com.tpanh.dinehub.entity.Carousel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ICarouselService {
    List<Carousel> getAllCarousels();
    Carousel getCarouselById(Integer id) throws Exception;
    Carousel createCarousel(MultipartFile file) throws Exception;
    Carousel updateCarousel(Integer id, MultipartFile file) throws Exception;
    void deleteCarousel(Integer id) throws Exception;
}
