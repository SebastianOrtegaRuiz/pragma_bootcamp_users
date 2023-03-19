package com.pragma.foodCourt.application.handler;

import com.pragma.foodCourt.application.dto.request.UsersRequestDto;
import com.pragma.foodCourt.application.dto.response.UsersResponseDto;
import com.pragma.foodCourt.application.dto.response.feign.RestaurantFeignDto;

import java.util.List;

public interface IUsersHandler {
    UsersResponseDto saveUsers(UsersRequestDto usersRequestDto);

    UsersResponseDto saveClient(UsersRequestDto usersRequestDto);

    List<UsersResponseDto> getAllUsers();

    UsersResponseDto getUserById(Long id);

    UsersResponseDto getUserByEmail(String email);

    List<RestaurantFeignDto> getAllRestaurants();
}
