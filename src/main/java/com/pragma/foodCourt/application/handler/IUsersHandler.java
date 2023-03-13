package com.pragma.foodCourt.application.handler;

import com.pragma.foodCourt.application.dto.request.UsersRequestDto;
import com.pragma.foodCourt.application.dto.response.UsersResponseDto;
import com.pragma.foodCourt.application.dto.response.feign.RestaurantFeignDto;

import java.util.List;

public interface IUsersHandler {
    void saveUsers(UsersRequestDto usersRequestDto);

    List<UsersResponseDto> getAllUsers();

    UsersResponseDto getUserById(Long id);

    List<RestaurantFeignDto> getAllRestaurants();
}
