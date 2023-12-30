package com.tpanh.dinehub.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "foods")
public class Food extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "price", nullable = false, precision = 10)
    private BigDecimal price;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "calories", nullable = false)
    private Integer calories;

    @Column(name = "weight", nullable = false)
    private Integer weight;

    @OneToMany(mappedBy = "food")
    private Set<CartItem> cartItems = new LinkedHashSet<>();

    @OneToMany(mappedBy = "food")
    private Set<FavoriteFood> favoriteFoods = new LinkedHashSet<>();

    @OneToMany(mappedBy = "food")
    private Set<OrderDetail> orderDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "food")
    private Set<RatingFood> ratingFoods = new LinkedHashSet<>();

}