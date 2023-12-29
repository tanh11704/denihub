package com.tpanh.dinehub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String email;
    private String password;
    private String fullName;
    @JsonProperty("phone_number")
    private String phoneNumber;
    private String avatar;
    private String address;
    @JsonProperty("is_active")
    private boolean isActive;
    @JsonProperty("role_id")
    private Integer role;
}
