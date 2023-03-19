package com.pragma.foodCourt.application.handler;

import com.pragma.foodCourt.application.dto.request.RolesRequestDto;
import com.pragma.foodCourt.application.dto.response.RolesResponseDto;

import java.util.List;

public interface IRolesHandler {
    void saveRoles(RolesRequestDto rolesRequestDto);

    List<RolesResponseDto> getAllRoles();

}
