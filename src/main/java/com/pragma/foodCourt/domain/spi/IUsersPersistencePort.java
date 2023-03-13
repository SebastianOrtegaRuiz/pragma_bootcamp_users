package com.pragma.foodCourt.domain.spi;

import com.pragma.foodCourt.domain.model.UsersModel;

import java.util.List;

public interface IUsersPersistencePort {
    UsersModel saveUsers(UsersModel usersModel);

    List<UsersModel> getAllUsers();

    UsersModel getUserById(Long id);
}
