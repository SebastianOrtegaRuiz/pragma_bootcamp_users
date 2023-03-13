package com.pragma.foodCourt.domain.usecase;

import com.pragma.foodCourt.domain.model.UsersModel;
import com.pragma.foodCourt.domain.spi.IUsersPersistencePort;
import com.pragma.foodCourt.infraestructure.exception.NoDataFoundException;
import com.pragma.foodCourt.infraestructure.output.entity.UsersEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsersUseCaseTest {

    @Mock
    IUsersPersistencePort usersPersistencePort;

    @InjectMocks
    UsersUseCase usersUseCase;

    @Test
    void mustSaveAnUser() {
        //Given
        //Modelo que va a guardar
        UsersModel usersModel = new UsersModel(0L, "prueba", "prueba", 11111111, "3152864598", "prueba@prueba.com", "ASDQEQ@#$$ERWADA", 1L, null);

        //When
        //Acciones que ejecuta el método para guardar un usuario
        when(usersPersistencePort.saveUsers(any())).thenReturn(usersModel);
        usersUseCase.saveUsers(usersModel);

        //Then
        //verifica que se guarde cualquier modelo
        verify(usersPersistencePort).saveUsers(any(UsersModel.class));
    }

    @Test
    void mustReturnAllUsers() {
        //Given
        //Se crea la lista de modelos para ejecutar el método
        List<UsersModel> modelList = new ArrayList<UsersModel>();

        UsersModel usersModel = new UsersModel(0L, "prueba", "prueba", 11111111, "3152864598", "prueba@prueba.com", "ASDQEQ@#$$ERWADA", 1L, null);

        modelList.add(usersModel);
        modelList.add(usersModel);
        modelList.add(usersModel);

        //When
        //Comportamiento del método
        when(usersPersistencePort.getAllUsers()).thenReturn(modelList);
        usersUseCase.getAllUsers();

        //Then
        //Se verifica que la lista no venga vacía
        Assertions.assertFalse(usersPersistencePort.getAllUsers().isEmpty());
    }

    @Test
    void mustReturnUserById() {
        //Given
        //Modelo que va a guardar
        UsersModel usersModel = new UsersModel(10L, "prueba", "prueba", 11111111, "3152864598", "prueba@prueba.com", "ASDQEQ@#$$ERWADA", 1L, null);

        //When
        //Se solicitan los datos correctamente
        when(usersPersistencePort.getUserById(anyLong())).thenReturn(usersModel);
        usersUseCase.getUserById(anyLong());

        //Then
        //Se verifica que traiga el usuario por Id
        verify(usersPersistencePort).getUserById(anyLong());
    }

}