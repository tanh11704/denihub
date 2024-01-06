package com.tpanh.dinehub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromoSavedDTO {
    @JsonProperty("promo_id")
    private Integer promoId;

    @JsonProperty("user_id")
    private Integer userId;
}
