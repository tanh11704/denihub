package com.tpanh.dinehub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
//    private Integer id;
    @JsonProperty("user_id")
    private Integer userId;
//    @JsonProperty("created_at")
//    private String createdAt;
//    @JsonProperty("updated_at")
//    private String updatedAt;
}
