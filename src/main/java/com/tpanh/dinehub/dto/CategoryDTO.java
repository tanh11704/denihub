package com.tpanh.dinehub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
//    private int id;
    private String name;
//    @JsonProperty("updated_at")
//    private String updatedAt;
//    @JsonProperty("created_at")
//    private String createdAt;
}
