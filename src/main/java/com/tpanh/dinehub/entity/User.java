package com.tpanh.dinehub.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String fullname;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    private String avatar;

    private String address;

    @Column(name = "is_delete", nullable = false)
    private Boolean isDelete = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PromoSaved> promoSaveds;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<FavoriteFood> favoriteFoods;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<RatingFood> ratingFoods;

}