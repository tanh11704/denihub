package com.tpanh.dinehub.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

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

    @Column(name = "full_name", nullable = false)
    private String fullname;

    @Column(name = "phone_number", unique = true)
    private Integer phoneNumber;

    private String avatar;

    private String address;

    @Column(name = "is_delete", nullable = false)
    private Boolean isDelete = false;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "role_id")
//    private Role role;

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    private Cart cart;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<PromoSaved> promoSaveds;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<FavoriteFood> favoriteFoods;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<RatingFood> ratingFoods;

}