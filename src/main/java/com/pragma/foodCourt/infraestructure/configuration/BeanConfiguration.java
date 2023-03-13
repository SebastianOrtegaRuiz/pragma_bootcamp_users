package com.pragma.foodCourt.infraestructure.configuration;

import com.pragma.foodCourt.domain.api.IRolesServicePort;
import com.pragma.foodCourt.domain.api.IUsersServicePort;
import com.pragma.foodCourt.domain.spi.IRolesPersistencePort;
import com.pragma.foodCourt.domain.spi.IUsersPersistencePort;
import com.pragma.foodCourt.domain.usecase.RolesUseCase;
import com.pragma.foodCourt.domain.usecase.UsersUseCase;
import com.pragma.foodCourt.infraestructure.output.adapter.RolesJpaAdapter;
import com.pragma.foodCourt.infraestructure.output.adapter.UsersJpaAdapter;
import com.pragma.foodCourt.infraestructure.output.mapper.IRolesEntityMapper;
import com.pragma.foodCourt.infraestructure.output.mapper.IUsersEntityMapper;
import com.pragma.foodCourt.infraestructure.output.repository.IRolesRepository;
import com.pragma.foodCourt.infraestructure.output.repository.IUsersRepository;
import com.pragma.foodCourt.infraestructure.utility.IUtilities;
import com.pragma.foodCourt.infraestructure.utility.Utilities;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IUsersRepository usersRepository;
    private final IUsersEntityMapper usersEntityMapper;
    private final IRolesRepository rolesRepository;
    private final IRolesEntityMapper rolesEntityMapper;

    @Bean
    public IUsersPersistencePort usersPersistencePort() {
        return new UsersJpaAdapter(usersRepository, usersEntityMapper);
    }

    @Bean
    public IUsersServicePort usersServicePort() {
        return new UsersUseCase(usersPersistencePort());
    }

    @Bean
    public IRolesPersistencePort rolesPersistencePort() {
        return new RolesJpaAdapter(rolesRepository, rolesEntityMapper);
    }

    @Bean
    public IRolesServicePort rolesServicePort() {
        return new RolesUseCase(rolesPersistencePort());
    }

    @Bean
    public IUtilities utility() {
        return new Utilities();
    }
}
