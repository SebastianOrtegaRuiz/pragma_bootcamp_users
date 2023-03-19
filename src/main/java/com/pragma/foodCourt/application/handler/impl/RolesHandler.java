package com.pragma.foodCourt.application.handler.impl;

import com.pragma.foodCourt.application.dto.request.RolesRequestDto;
import com.pragma.foodCourt.application.dto.response.RolesResponseDto;
import com.pragma.foodCourt.application.handler.IRolesHandler;
import com.pragma.foodCourt.application.mapper.IRolesRequestMapper;
import com.pragma.foodCourt.application.mapper.IRolesResponseMapper;
import com.pragma.foodCourt.domain.api.IRolesServicePort;
import com.pragma.foodCourt.domain.model.RolesModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RolesHandler implements IRolesHandler {
    private final IRolesServicePort rolesServicePort;
    private final IRolesRequestMapper rolesRequestMapper;
    private final IRolesResponseMapper rolesResponseMapper;
    @Override
    public void saveRoles(RolesRequestDto rolesRequestDto) {
        RolesModel rolesModel = rolesRequestMapper.toRoles(rolesRequestDto);
        rolesServicePort.saveRoles(rolesModel);
    }

    @Override
    public List<RolesResponseDto> getAllRoles() {
        return rolesResponseMapper.toResponseList(rolesServicePort.getAllRoles());
    }
}
