package com.pragma.foodCourt.infraestructure.output.adapter;

import com.pragma.foodCourt.domain.model.UsersModel;
import com.pragma.foodCourt.domain.spi.IUsersPersistencePort;
import com.pragma.foodCourt.infraestructure.exception.NoDataFoundException;
import com.pragma.foodCourt.infraestructure.output.entity.UsersEntity;
import com.pragma.foodCourt.infraestructure.output.mapper.IUsersEntityMapper;
import com.pragma.foodCourt.infraestructure.output.repository.IUsersRepository;

import javax.validation.Valid;
import java.util.List;

public class UsersJpaAdapter implements IUsersPersistencePort {
    private final IUsersRepository usersRepository;
    private final IUsersEntityMapper usersEntityMapper;

    public UsersJpaAdapter(IUsersRepository usersRepository, IUsersEntityMapper usersEntityMapper) {
        this.usersRepository = usersRepository;
        this.usersEntityMapper = usersEntityMapper;
    }

    @Override
    public UsersModel saveUsers(@Valid UsersModel usersModel) {
        UsersEntity usersEntity = usersRepository.save(usersEntityMapper.toEntity(usersModel));
        return usersEntityMapper.toUsersModel(usersEntity);

    }

    @Override
    public UsersModel saveClient(UsersModel usersModel) {
        UsersEntity usersEntity = usersRepository.save(usersEntityMapper.toEntity(usersModel));
        return usersEntityMapper.toUsersModel(usersEntity);
    }

    @Override
    public List<UsersModel> getAllUsers() {
        List<UsersEntity> entityList = usersRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }

        /*String passw = entityList.get(1).getPassword();
        System.out.println(encryptPassword.verifyPass("123", passw));*/

        return usersEntityMapper.toUsersModelList(entityList);

    }

    @Override
    public UsersModel getUserById(Long id) {
        UsersEntity usersEntity = usersRepository.findById(id).orElse(null);
        return usersEntityMapper.toUsersModel(usersEntity);
    }

    @Override
    public UsersModel getUserByEmail(String email) {
        UsersEntity usersEntity = usersRepository.findOneByEmail(email).orElse(null);
        return usersEntityMapper.toUsersModel(usersEntity);
    }
}
