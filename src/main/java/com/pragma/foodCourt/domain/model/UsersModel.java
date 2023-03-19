package com.pragma.foodCourt.domain.model;

import com.pragma.foodCourt.infraestructure.output.entity.RolesEntity;

public class UsersModel {
    private Long id;
    private String name;
    private String last_name;
    private int identity_card;
    private String cellphone;
    private String email;
    private String password;
    private Long id_rol;
    private RolesModel rolesModel;

    public UsersModel(Long id, String name, String last_name, int identity_card, String cellphone, String email, String password, Long id_rol, RolesModel rolesModel) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.identity_card = identity_card;
        this.cellphone = cellphone;
        this.email = email;
        this.password = password;
        this.id_rol = id_rol;
        this.rolesModel = rolesModel;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getLast_name() {
        return last_name;
    }

    public int getIdentity_card() {
        return identity_card;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Long getId_rol() {
        return id_rol;
    }

    public RolesModel getRolesModel() {
        return rolesModel;
    }

}
