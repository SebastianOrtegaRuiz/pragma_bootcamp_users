package com.pragma.foodCourt.infraestructure.output.mapper;

import com.pragma.foodCourt.domain.model.RolesModel;
import com.pragma.foodCourt.infraestructure.output.entity.RolesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IRolesEntityMapper {
    RolesEntity toEntity(RolesModel roles);
    RolesModel toRolesModel(RolesEntity rolesEntity);
    List<RolesModel> toRolesModelList(List<RolesEntity> rolesEntityList);
}
