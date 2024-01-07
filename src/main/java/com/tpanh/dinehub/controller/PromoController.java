package com.tpanh.dinehub.controller;

import com.tpanh.dinehub.dto.PromoDTO;
import com.tpanh.dinehub.entity.Promo;
import com.tpanh.dinehub.service.impl.IPromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/promos")
public class PromoController {

    @Autowired
    IPromoService promoService;

    @GetMapping
    public ResponseEntity<List<Promo>> getAllPromos() {
        List<Promo> promos = promoService.getAllPromos();
        return ResponseEntity.ok(promos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promo> getPromoById(@PathVariable Integer id) throws Exception {
        Promo promo = promoService.getPromoById(id);
        return ResponseEntity.ok(promo);
    }

    @PostMapping
    public ResponseEntity<Promo> createPromo(@RequestBody PromoDTO promo) {
        Promo newPromo = promoService.createPromo(promo);
        return ResponseEntity.ok(newPromo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promo> updatePromo(@PathVariable Integer id, @RequestBody PromoDTO promo) throws Exception {
        Promo promoUpdate = promoService.updatePromo(id, promo);
        return ResponseEntity.ok(promoUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePromo(@PathVariable Integer id) {
        promoService.deletePromo(id);
        return ResponseEntity.ok().build();
    }
}
