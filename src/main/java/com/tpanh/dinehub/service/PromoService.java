package com.tpanh.dinehub.service;

import com.tpanh.dinehub.dto.PromoDTO;
import com.tpanh.dinehub.entity.Category;
import com.tpanh.dinehub.entity.Promo;
import com.tpanh.dinehub.exception.DataNotFoundException;
import com.tpanh.dinehub.reponsitory.CategoryRepository;
import com.tpanh.dinehub.reponsitory.PromoRepository;
import com.tpanh.dinehub.service.impl.IPromoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromoService implements IPromoService {

    @Autowired
    PromoRepository promoRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Promo> getAllPromos() {
        return promoRepository.findAll();
    }

    @Override
    public Promo getPromoById(Integer id) throws Exception {
        return promoRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Promo not found"));
    }

    @Override
    public Promo createPromo(PromoDTO promo) {
        Promo newPromo = new Promo();
        modelMapper.map(promo, newPromo);
        return promoRepository.save(newPromo);
    }

    @Override
    public Promo updatePromo(Integer id, PromoDTO promo) throws Exception {
        Promo existingPromo = promoRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Promo not found"));
        modelMapper.map(promo, existingPromo);
        return promoRepository.save(existingPromo);
    }

    @Override
    public void deletePromo(Integer id) {
        Optional<Promo> optionalPromo = promoRepository.findById(id);
        optionalPromo.ifPresent(promo -> promoRepository.delete(promo));
    }
}
