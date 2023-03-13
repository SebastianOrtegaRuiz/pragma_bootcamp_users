package com.pragma.foodCourt.application.dto.response.feign;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantFeignDto {
    private String name;
    private Long id_category;
}

