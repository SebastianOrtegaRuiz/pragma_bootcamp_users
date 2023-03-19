package com.pragma.foodCourt.application.mapper;

import com.pragma.foodCourt.application.dto.response.RolesResponseDto;
import com.pragma.foodCourt.domain.model.RolesModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRolesResponseMapper {

    RolesResponseDto toResponse(RolesModel rolesModel);

    List<RolesResponseDto> toResponseList(List<RolesModel> rolesModelList);
}
