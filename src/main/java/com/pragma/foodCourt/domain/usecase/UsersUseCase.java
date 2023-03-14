package com.pragma.foodCourt.domain.usecase;

import com.pragma.foodCourt.domain.api.IUsersServicePort;
import com.pragma.foodCourt.domain.model.UsersModel;
import com.pragma.foodCourt.domain.spi.IUsersPersistencePort;
import com.pragma.foodCourt.domain.validations.Validations;

import java.util.List;

public class UsersUseCase implements IUsersServicePort {
    private final IUsersPersistencePort usersPersistencePort;
    private final Validations validations;

    public UsersUseCase(IUsersPersistencePort usersPersistencePort, Validations validations) {
        this.usersPersistencePort = usersPersistencePort;
        this.validations = validations;
    }

    @Override
    public void saveUsers(UsersModel usersModel) {
        //usersPersistencePort.getAllUsers().size();
        //primer paso, obtener el id del usuario actual en sesion context holder security spring
        //segundo paso, consultar en base de datos la informacion del usuario actual con el id
        if((usersModel.getId_rol()==2&&validations.hasRole("ADMINISTRADOR"))||(usersModel.getId_rol()==3&&validations.hasRole("PROPIETARIO"))){
            usersPersistencePort.saveUsers(usersModel);
        }
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
