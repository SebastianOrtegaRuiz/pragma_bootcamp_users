package com.pragma.foodCourt.domain.usecase;

import com.pragma.foodCourt.domain.model.RolesModel;
import com.pragma.foodCourt.domain.spi.IRolesPersistencePort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RolesUseCaseTest {

    @Mock
    IRolesPersistencePort rolesPersistencePort;

    @InjectMocks
    RolesUseCase rolesUseCase;

    @Test
    void mustSaveARole() {
        //Given
        //Modelo que va a guardar
        RolesModel rolesModel = new RolesModel(1L,
                "",
                "puede crear cuentas propietario");

        //When
        //Acciones que ejecuta el método para guardar un rol
        when(rolesPersistencePort.saveRoles(any())).thenReturn(rolesModel);
        rolesUseCase.saveRoles(rolesModel);

        //Then
        //verifica que se guarde cualquier modelo de rol
        verify(rolesPersistencePort).saveRoles(any(RolesModel.class));
    }

    @Test
    void mustReturnAllRoles() {
        //Given
        //Se crea la lista de modelos para ejecutar el método
        List<RolesModel> modelList = new ArrayList<RolesModel>();

        RolesModel rolesModel = new RolesModel(1L,
                "",
                "puede crear cuentas propietario");

        modelList.add(rolesModel);
        modelList.add(rolesModel);
        modelList.add(rolesModel);

        //When
        //Comportamiento del método
        when(rolesPersistencePort.getAllRoles()).thenReturn(modelList);
        rolesUseCase.getAllRoles();

        //Then
        //Se verifica que la lista no venga vacía
        Assertions.assertFalse(rolesPersistencePort.getAllRoles().isEmpty());
    }
}