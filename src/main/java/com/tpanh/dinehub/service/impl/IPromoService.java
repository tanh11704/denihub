package com.tpanh.dinehub.service.impl;

import com.tpanh.dinehub.dto.PromoDTO;
import com.tpanh.dinehub.entity.Promo;

import java.util.List;

public interface IPromoService {
    List<Promo> getAllPromos();
    Promo getPromoById(Integer id) throws Exception;
    Promo createPromo(PromoDTO promo);
    Promo updatePromo(Integer id, PromoDTO promo) throws Exception;
    void deletePromo(Integer id);
}
