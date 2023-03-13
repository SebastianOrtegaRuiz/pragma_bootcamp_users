package com.pragma.foodCourt.application.mapper;

import com.pragma.foodCourt.application.dto.response.UsersResponseDto;
import com.pragma.foodCourt.domain.model.UsersModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUsersResponseMapper {
    @Mapping(target = "rolesResponseDto", source = "rolesModel")
    UsersResponseDto toResponse(UsersModel usersModel);

    List<UsersResponseDto> toResponseList(List<UsersModel> usersModelList);

}
