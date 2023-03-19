package com.pragma.foodCourt.infraestructure.output.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
;import java.io.Serializable;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private Long id;

    @NotNull
    @NotEmpty(message = "Name cannot be empty")
    @Column(length = 45, nullable = false)
    private String name;

    @NotNull
    @NotEmpty(message = "Last name cannot be empty")
    @Column(length = 45, nullable = false)
    private String last_name;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private int identity_card;

    @NotNull
    @NotEmpty(message = "Cellphone cannot be empty")
    @Column(length = 13, nullable = false)
    private String cellphone;

    @NotNull
    @Email(regexp = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")
    @Column(length = 45, nullable = false)
    private String email;

    @NotNull
    @NotEmpty(message = "Password cannot be empty")
    @Column(length = 60, nullable = false)
    private String password;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Long id_rol;

    @OneToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id", insertable = false, updatable = false)
    private RolesEntity rolesEntity;
}
