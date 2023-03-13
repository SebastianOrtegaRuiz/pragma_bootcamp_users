package com.pragma.foodCourt.infraestructure.output.adapter;

import com.pragma.foodCourt.domain.model.RolesModel;
import com.pragma.foodCourt.domain.spi.IRolesPersistencePort;
import com.pragma.foodCourt.infraestructure.exception.NoDataFoundException;
import com.pragma.foodCourt.infraestructure.output.entity.RolesEntity;
import com.pragma.foodCourt.infraestructure.output.mapper.IRolesEntityMapper;
import com.pragma.foodCourt.infraestructure.output.repository.IRolesRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
public class RolesJpaAdapter implements IRolesPersistencePort {
    private final IRolesRepository rolesRepository;
    private final IRolesEntityMapper rolesEntityMapper;

    @Override
    public RolesModel saveRoles(@Valid RolesModel rolesModel) {
        RolesEntity rolesEntity = rolesRepository.save(rolesEntityMapper.toEntity(rolesModel));
        if(rolesEntity == null) {
            throw new NoDataFoundException();
        }
        return rolesEntityMapper.toRolesModel(rolesEntity);
    }

    @Override
    public List<RolesModel> getAllRoles() {
        List<RolesEntity> entityList = rolesRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return rolesEntityMapper.toRolesModelList(entityList);
    }
}
