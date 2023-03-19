package com.pragma.foodCourt.domain.api;

import com.pragma.foodCourt.domain.model.RolesModel;

import java.util.List;

public interface IRolesServicePort {
    void saveRoles(RolesModel rolesModel);

    List<RolesModel> getAllRoles();
}
