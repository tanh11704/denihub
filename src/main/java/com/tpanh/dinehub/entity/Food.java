package com.tpanh.dinehub.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "foods")
public class Food extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String image;

    @Column(nullable = false, precision = 10)
    private Double price;

    private String description;

    @Column( nullable = false)
    private Integer calories;

    @Column(nullable = false)
    private Integer weight;

    @Column(name = "food_type")
    private String foodType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

//    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
//    private List<CartItem> cartItems;

//    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
//    private List<FavoriteFood> favoriteFoods;

//    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
//    private List<OrderDetail> orderDetails;

//    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
//    private List<FoodTag> foodTags;

//    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
//    private List<RatingFood> ratingFoods;

}