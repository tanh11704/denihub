package com.tpanh.dinehub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    @JsonProperty("user_id")
    private Integer userId;

    private String fullname;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private String address;

    private String note;

    private Double total;

}
