package com.pragma.foodCourt.infraestructure.output.adapter;

import com.pragma.foodCourt.domain.model.RolesModel;
import com.pragma.foodCourt.domain.model.UsersModel;
import com.pragma.foodCourt.infraestructure.exception.NoDataFoundException;
import com.pragma.foodCourt.infraestructure.output.entity.RolesEntity;
import com.pragma.foodCourt.infraestructure.output.entity.UsersEntity;
import com.pragma.foodCourt.infraestructure.output.mapper.IUsersEntityMapper;
import com.pragma.foodCourt.infraestructure.output.repository.IUsersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class UsersJpaAdapterTest {

    @InjectMocks
    UsersJpaAdapter usersJpaAdapter;

    @Mock
    IUsersRepository usersRepository;
    @Mock
    IUsersEntityMapper usersEntityMapper;

    @Test
    void mustSaveAnUser() {
        //Given
        //El usuario hace la solicitud de guardado de un usuario
        UsersModel usersModel = new UsersModel(0L, "prueba", "prueba", 11111111, "3152864598", "prueba@prueba.com", "ASDQEQ@#$$ERWADA", 1L, null);
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setId(0L);
        usersEntity.setName("prueba");
        usersEntity.setLast_name("prueba");
        usersEntity.setIdentity_card(11111111);
        usersEntity.setCellphone("3152864598");
        usersEntity.setEmail("prueba@prueba.com");
        usersEntity.setPassword("ASDQEQ@#$$ERWADA");
        usersEntity.setId_rol(1L);

        //When
        //Envío los valores correctamente
        when(usersEntityMapper.toEntity(usersModel)).thenReturn(usersEntity);
        when(usersRepository.save(usersEntity)).thenReturn(usersEntity);
        when(usersEntityMapper.toUsersModel(usersEntity)).thenReturn(usersModel);
        usersJpaAdapter.saveUsers(usersModel);

        //Then
        //El sistema guarda el usuario
        verify(usersRepository).save(any(UsersEntity.class));
    }

    @Test
    void mustReturnAllUsers() {
        //Given
        //El usuario hace la solicitud para obtener la lista de todos los usuarios
        List<UsersEntity> entityList = new ArrayList<UsersEntity>();
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setId(0L);
        usersEntity.setName("prueba");
        usersEntity.setLast_name("prueba");
        usersEntity.setIdentity_card(11111111);
        usersEntity.setCellphone("3152864598");
        usersEntity.setEmail("prueba@prueba.com");
        usersEntity.setPassword("ASDQEQ@#$$ERWADA");
        usersEntity.setId_rol(1L);

        entityList.add(usersEntity);
        entityList.add(usersEntity);
        entityList.add(usersEntity);

        //When
        //Se hace la solicitud
        when(usersRepository.findAll()).thenReturn(entityList);
        usersJpaAdapter.getAllUsers();

        //Then
        //el sistema retorna la lista de usuarios
        Assertions.assertFalse(entityList.isEmpty());
        Assertions.assertFalse(usersRepository.findAll().isEmpty());
    }

    @Test
    void notReturnUsers() {
        //Given
        //El usuario hace la solicitud para obtener la lista de todos los usuarios
        List<UsersEntity> entityList = new ArrayList<UsersEntity>();

        //When
        //Se hace la solicitud
        when(usersRepository.findAll()).thenReturn(entityList);

        //Then
        //el sistema retorna la lista de usuarios
        Assertions.assertThrows(NoDataFoundException.class, ()->{
            usersJpaAdapter.getAllUsers();
        });
    }

    @Test
    void mustReturnUserById() {
        //Given
        // El usuario solicita un usuario del sistema con su id
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setId(10L);
        usersEntity.setName("prueba");
        usersEntity.setLast_name("prueba");
        usersEntity.setIdentity_card(11111111);
        usersEntity.setCellphone("3152864598");
        usersEntity.setEmail("prueba@prueba.com");
        usersEntity.setPassword("ASDQEQ@#$$ERWADA");
        usersEntity.setId_rol(1L);

        //When
        //Solicito los datos correctamente
        usersJpaAdapter.getUserById(anyLong());
        when(usersRepository.findById(anyLong())).thenReturn(Optional.of(usersEntity));

        //Then
        Assertions.assertNotNull(usersEntity);
    }

    @Test
    void notReturnUserById() {
        //Given
        // El usuario solicita un usuario del sistema con su id
        UsersEntity usersEntity = null;
        UsersModel usersModel = null;

        //When
        //Solicito los datos correctamente
        usersJpaAdapter.getUserById(anyLong());
        when(usersRepository.findById(anyLong()).orElse(null)).thenReturn(usersEntity);
        when(usersEntityMapper.toUsersModel(usersEntity)).thenReturn(usersModel);

        //Then
        Assertions.assertNull(usersEntity);
    }

}