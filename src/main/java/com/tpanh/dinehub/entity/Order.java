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
@Table(name = "orders")
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Column(name = "phone_number", nullable = false, length = 10)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Lob
    @Column(name = "note")
    private String note;

    @Lob
    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "total", nullable = false, precision = 10)
    private BigDecimal total;

    @OneToMany(mappedBy = "oder")
    private Set<OrderDetail> orderDetails = new LinkedHashSet<>();

}