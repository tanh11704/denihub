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
public class UserDTO {
    private String email;

    @JsonProperty("phone_number")
    private Integer phoneNumber;

    private String password;

    @JsonProperty("password_confirm")
    private String passwordConfirm;

    private String fullname;

    private String avatar;

    private String address;
}
