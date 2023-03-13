package com.pragma.foodCourt.domain.usecase;

import com.pragma.foodCourt.domain.api.IUsersServicePort;
import com.pragma.foodCourt.domain.model.UsersModel;
import com.pragma.foodCourt.domain.spi.IUsersPersistencePort;

import java.util.List;

public class UsersUseCase implements IUsersServicePort {
    private final IUsersPersistencePort usersPersistencePort;

    public UsersUseCase(IUsersPersistencePort usersPersistencePort) {
        this.usersPersistencePort = usersPersistencePort;
    }

    @Override
    public void saveUsers(UsersModel usersModel) {
        //usersPersistencePort.getAllUsers().size();
        //primer paso, obtener el id del usuario actual en sesion context holder security spring
        //segundo paso, consultar en base de datos la informacion del usuario actual con el id
        usersPersistencePort.saveUsers(usersModel);
    }

    public void updateUser(UsersModel usersModel) {
        //primer paso: obtener el usuario con el id
        //segundo paso: hacer la modificacion
        //tercer paso: guardo el objeto que se obtuvo en el primer paso
    }

    @Override
    public List<UsersModel> getAllUsers() {
        return usersPersistencePort.getAllUsers();
    }

    public UsersModel getUserById(Long id) {
        return usersPersistencePort.getUserById(id);
    }
}
