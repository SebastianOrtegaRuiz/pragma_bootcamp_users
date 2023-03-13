package com.pragma.foodCourt.domain.usecase;

import com.pragma.foodCourt.domain.api.IRolesServicePort;
import com.pragma.foodCourt.domain.model.RolesModel;
import com.pragma.foodCourt.domain.spi.IRolesPersistencePort;

import java.util.List;

public class RolesUseCase implements IRolesServicePort {

    private final IRolesPersistencePort rolesPersistencePort;

    public RolesUseCase(IRolesPersistencePort rolesPersistencePort) {
        this.rolesPersistencePort = rolesPersistencePort;
    }

    @Override
    public void saveRoles(RolesModel rolesModel) {
        rolesPersistencePort.saveRoles(rolesModel);
    }

    @Override
    public List<RolesModel> getAllRoles() {
        return rolesPersistencePort.getAllRoles();
    }
}
