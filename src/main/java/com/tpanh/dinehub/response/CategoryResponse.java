package com.tpanh.dinehub.response;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse extends BaseResponse {
    private Integer id;
    private String name;
    private String image;
}
