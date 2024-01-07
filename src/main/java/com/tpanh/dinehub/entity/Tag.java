package com.tpanh.dinehub.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tags")
@JsonPropertyOrder({"id", "name", "created_at", "updated_at"})
public class Tag extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

//    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<FoodTag> foodTags;

}