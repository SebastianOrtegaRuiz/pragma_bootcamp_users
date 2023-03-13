package com.pragma.foodCourt.infraestructure.output.mapper;

import com.pragma.foodCourt.domain.model.UsersModel;
import com.pragma.foodCourt.infraestructure.output.entity.UsersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring"
)
public interface IUsersEntityMapper {
    @Mapping(target = "rolesEntity", source = "rolesModel")
    UsersEntity toEntity(UsersModel user);
    @Mapping(target = "rolesModel", source = "rolesEntity")
    UsersModel toUsersModel(UsersEntity usersEntity);
    List<UsersModel> toUsersModelList(List<UsersEntity> userEntityList);
}
