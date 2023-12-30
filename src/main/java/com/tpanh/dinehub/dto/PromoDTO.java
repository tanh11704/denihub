package com.tpanh.dinehub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromoDTO {
//    private Integer id;
    @JsonProperty("start_date")
    private Date startDate;
    @JsonProperty("end_date")
    private Date endDate;
    private Integer percent;
//    @JsonProperty("updated_at")
//    private String updatedAt;
//    @JsonProperty("created_at")
//    private String createdAt;
}
