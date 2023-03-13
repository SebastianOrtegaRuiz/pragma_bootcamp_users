package com.pragma.foodCourt.domain.api;

import com.pragma.foodCourt.domain.model.UsersModel;

import java.util.List;

public interface IUsersServicePort {
    void saveUsers(UsersModel usersModel);

    List<UsersModel> getAllUsers();

    UsersModel getUserById(Long id);
}
