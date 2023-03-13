package com.pragma.foodCourt.application.mapper;

import com.pragma.foodCourt.application.dto.request.RolesRequestDto;
import com.pragma.foodCourt.domain.model.RolesModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface IRolesRequestMapper {
    RolesModel toRoles(RolesRequestDto rolesRequestDto);
}
