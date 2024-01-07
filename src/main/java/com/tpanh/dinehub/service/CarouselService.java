package com.tpanh.dinehub.service;

import com.tpanh.dinehub.entity.Carousel;
import com.tpanh.dinehub.exception.DataNotFoundException;
import com.tpanh.dinehub.reponsitory.CarouselRepository;
import com.tpanh.dinehub.service.impl.ICarouselService;
import com.tpanh.dinehub.service.impl.IFilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class CarouselService implements ICarouselService {

    @Autowired
    CarouselRepository carouselRepository;
    @Autowired
    IFilesStorageService filesStorageService;

    @Override
    public List<Carousel> getAllCarousels() {
        return carouselRepository.findAll();
    }

    @Override
    public Carousel getCarouselById(Integer id) throws Exception {
        Carousel carousel = carouselRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("Carousel not found")
        );
        return carousel;
    }

    @Override
    public Carousel createCarousel(MultipartFile file) throws Exception {
        Carousel newCarousel = new Carousel();

        String filePath = filesStorageService.save(file, "carousels");

        newCarousel.setImage(filePath);
        carouselRepository.save(newCarousel);

        return newCarousel;
    }

    @Override
    public Carousel updateCarousel(Integer id, MultipartFile file) throws Exception {
        Carousel existingCarousel = carouselRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("Carousel not found")
        );

        if (existingCarousel != null) {
            Path existingImagePath = Paths.get(existingCarousel.getImage());
            Files.deleteIfExists(existingImagePath);
        }

        String filePath = filesStorageService.save(file, "carousels");

        existingCarousel.setImage(filePath);
        carouselRepository.save(existingCarousel);

        return existingCarousel;
    }

    @Override
    public void deleteCarousel(Integer id) throws Exception {
        Carousel existingCarousel = carouselRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Carousel not found"));

        Path existingImagePath = Paths.get(existingCarousel.getImage());
        Files.deleteIfExists(existingImagePath);

        carouselRepository.delete(existingCarousel);
    }
}
