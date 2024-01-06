package com.tpanh.dinehub.dto;

import jakarta.persistence.Column;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    @Column(name = "user_id")
    private Integer userId;
}
