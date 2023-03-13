package com.pragma.foodCourt.application.mapper;

import com.pragma.foodCourt.application.dto.request.UsersRequestDto;
import com.pragma.foodCourt.domain.model.UsersModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUsersRequestMapper {
    UsersModel toUsers(UsersRequestDto usersRequestDto);
}
