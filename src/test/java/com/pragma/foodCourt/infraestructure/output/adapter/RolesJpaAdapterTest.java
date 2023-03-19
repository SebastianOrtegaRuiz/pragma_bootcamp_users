package com.pragma.foodCourt.infraestructure.output.adapter;

import com.pragma.foodCourt.domain.model.RolesModel;
import com.pragma.foodCourt.infraestructure.exception.NoDataFoundException;
import com.pragma.foodCourt.infraestructure.output.entity.RolesEntity;
import com.pragma.foodCourt.infraestructure.output.mapper.IRolesEntityMapper;
import com.pragma.foodCourt.infraestructure.output.repository.IRolesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RolesJpaAdapterTest {

    @Mock
    IRolesRepository rolesRepository;

    @Mock
    IRolesEntityMapper rolesEntityMapper;

    @InjectMocks
    RolesJpaAdapter rolesJpaAdapter;

    @Test
    void mustSaveARole() {
        //Given
        //se requiere guardar un entity rol y retornar un roles model
        RolesModel rolesModel = new RolesModel(1L,
                "Administrador",
                "puede crear cuentas propietario");

        RolesEntity rolesEntity = new RolesEntity();
        rolesEntity.setId(1L);
        rolesEntity.setName("Administrador");
        rolesEntity.setDescription("puede crear cuentas propietario");

        //When
        //cuando se mandan los valores correctos debe realizar las siguientes acciones
        when(rolesEntityMapper.toEntity(any())).thenReturn(rolesEntity);
        when(rolesRepository.save(any())).thenReturn(rolesEntity);
        when(rolesEntityMapper.toRolesModel(any())).thenReturn(rolesModel);
        rolesJpaAdapter.saveRoles(rolesModel);

        //then
        //se verifica que se guarde correctamente
        verify(rolesRepository).save(any(RolesEntity.class));
    }

    @Test
    void saveAnInvalidRole() {
        //Given
        //se requiere guardar un entity rol y retornar un roles model
        RolesModel rolesModel = new RolesModel(1L,
                "",
                "puede crear cuentas propietario");

        RolesEntity rolesEntity = new RolesEntity();
        rolesEntity.setId(1L);
        rolesEntity.setName("");
        rolesEntity.setDescription("puede crear cuentas propietario");

        //When
        //cuando se mandan los valores incorrectos debe realizar las siguientes acciones
        when(rolesEntityMapper.toEntity(any())).thenReturn(rolesEntity);
        //when(rolesRepository.save(any())).thenReturn(rolesEntity);

        //then
        //se verifica que se arroje la excepcion
        Assertions.assertThrows(NoDataFoundException.class, () ->{
            rolesJpaAdapter.saveRoles(rolesModel);
        });
    }

    @Test
    void mustReturnAllRoles() {
        //Given
        //se crean las listas que busca en la base de datos y convierte a model
        List<RolesModel> rolesModelList = new ArrayList<>();
        List<RolesEntity> rolesEntityList = new ArrayList<>();

        RolesModel rolesModel = new RolesModel(1L,
                "Administrador",
                "puede crear cuentas propietario");

        RolesEntity rolesEntity = new RolesEntity();
        rolesEntity.setId(1L);
        rolesEntity.setName("Administrador");
        rolesEntity.setDescription("puede crear cuentas propietario");

        rolesModelList.add(rolesModel);
        rolesModelList.add(rolesModel);

        rolesEntityList.add(rolesEntity);
        rolesEntityList.add(rolesEntity);

        //When
        //se verifica que se ejecuten cada una de las acciones
        when(rolesRepository.findAll()).thenReturn(rolesEntityList);
        when(rolesEntityMapper.toRolesModelList(rolesEntityList)).thenReturn(rolesModelList);
        rolesJpaAdapter.getAllRoles();

        //Then
        //se verifica que se llame la funcion y no traiga nulo
        Assertions.assertNotNull(rolesEntityList);

    }

    @Test
    void notReturnRoles() {
        //Given
        //se necesita verificar que una lista venga vacía
        List<RolesEntity> rolesEntityList = new ArrayList<>();

        //When
        //se comprueba que se haga el llamado a la base de datos
        when(rolesRepository.findAll()).thenReturn(rolesEntityList);

        //Then
        //Se verifica que se lance la excepcion
        Assertions.assertThrows(NoDataFoundException.class, () -> {
            rolesJpaAdapter.getAllRoles();
        });

    }
}