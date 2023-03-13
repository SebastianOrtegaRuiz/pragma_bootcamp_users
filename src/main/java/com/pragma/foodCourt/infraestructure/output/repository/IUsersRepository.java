package com.pragma.foodCourt.infraestructure.output.repository;

import com.pragma.foodCourt.infraestructure.output.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsersRepository extends JpaRepository<UsersEntity, Long> {
    Optional<UsersEntity> findOneByEmail(String email);
}
