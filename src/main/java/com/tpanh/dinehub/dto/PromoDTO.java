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
    private String code;

    @JsonProperty("end_date")
    private Date endDate;

    private Integer percent;
}
