package com.pragma.foodCourt.domain.spi;

import com.pragma.foodCourt.domain.model.RolesModel;

import java.util.List;

public interface IRolesPersistencePort {
    RolesModel saveRoles(RolesModel rolesModel);

    List<RolesModel> getAllRoles();
}
