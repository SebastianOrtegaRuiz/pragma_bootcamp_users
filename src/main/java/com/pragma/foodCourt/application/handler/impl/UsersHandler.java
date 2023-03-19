package com.pragma.foodCourt.application.handler.impl;

import com.pragma.foodCourt.application.dto.request.UsersRequestDto;
import com.pragma.foodCourt.application.dto.response.UsersResponseDto;
import com.pragma.foodCourt.application.dto.response.feign.RestaurantFeignDto;
import com.pragma.foodCourt.application.handler.IUsersHandler;
import com.pragma.foodCourt.application.mapper.IUsersRequestMapper;
import com.pragma.foodCourt.application.mapper.IUsersResponseMapper;
import com.pragma.foodCourt.application.mapper.feign.IRestaurantFeignClient;
import com.pragma.foodCourt.domain.api.IUsersServicePort;
import com.pragma.foodCourt.domain.model.UsersModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UsersHandler implements IUsersHandler {
    private final IUsersServicePort usersServicePort;
    private final IUsersRequestMapper usersRequestMapper;
    private final IUsersResponseMapper usersResponseMapper;
    private final IRestaurantFeignClient restaurant;
    @Override
    public UsersResponseDto saveUsers(UsersRequestDto usersRequestDto) {
        UsersModel usersModel = usersRequestMapper.toUsers(usersRequestDto);
        return usersResponseMapper.toResponse(usersServicePort.saveUsers(usersModel));
    }

    @Override
    public UsersResponseDto saveClient(UsersRequestDto usersRequestDto) {
        UsersModel usersModel = usersRequestMapper.toUsers(usersRequestDto);
        return usersResponseMapper.toResponse(usersServicePort.saveClient(usersModel));
    }

    @Override
    public List<UsersResponseDto> getAllUsers() {
        return usersResponseMapper.toResponseList(usersServicePort.getAllUsers());
    }

    public List<RestaurantFeignDto> getAllRestaurants() {
        return restaurant.getAll();
    }

    @Override
    public UsersResponseDto getUserById(Long id) {
        return usersResponseMapper.toResponse(usersServicePort.getUserById(id));
    }

    @Override
    public UsersResponseDto getUserByEmail(String email) {
        return usersResponseMapper.toResponse(usersServicePort.getUserByEmail(email));
    }
}
