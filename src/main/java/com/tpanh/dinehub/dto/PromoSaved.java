package com.tpanh.dinehub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromoSaved {
//    private Integer id;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("promo_id")
    private Integer promoId;
//    @JsonProperty("updated_at")
//    private String updatedAt;
//    @JsonProperty("created_at")
//    private String createdAt;
}
