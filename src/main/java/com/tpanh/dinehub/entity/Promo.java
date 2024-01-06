package com.tpanh.dinehub.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "promos")
public class Promo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private Integer percent;

    @OneToMany(mappedBy = "promo", cascade = CascadeType.ALL)
    private List<PromoSaved> promoSaveds;
}