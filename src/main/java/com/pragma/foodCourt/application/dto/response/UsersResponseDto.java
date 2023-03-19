package com.pragma.foodCourt.application.dto.response;

import com.pragma.foodCourt.application.dto.response.feign.RestaurantFeignDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersResponseDto {
    private Long id;
    private String name;
    private Long id_rol;
    private RolesResponseDto rolesResponseDto;

}
