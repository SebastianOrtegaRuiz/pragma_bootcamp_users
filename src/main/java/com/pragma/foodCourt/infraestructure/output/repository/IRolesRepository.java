package com.pragma.foodCourt.infraestructure.output.repository;

import com.pragma.foodCourt.infraestructure.output.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolesRepository extends JpaRepository<RolesEntity, Long> {

}
