package com.pragma.foodCourt.infraestructure.security;

import com.pragma.foodCourt.infraestructure.output.entity.UsersEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final UsersEntity usersEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority(usersEntity.getRolesEntity().getName().toUpperCase()));
        return list;
    } //aqui se añade a la coleccion los permisos por roles

    @Override
    public String getPassword() {
        return usersEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return usersEntity.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getName(){
        return usersEntity.getName();
    }
}
