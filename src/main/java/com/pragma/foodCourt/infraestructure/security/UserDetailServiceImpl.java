package com.pragma.foodCourt.infraestructure.security;

import com.pragma.foodCourt.infraestructure.output.entity.UsersEntity;
import com.pragma.foodCourt.infraestructure.output.repository.IUsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final IUsersRepository usersRepository;

    public UserDetailServiceImpl(IUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsersEntity usersEntity =  usersRepository.findOneByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("El usuario con email" + email + " no existe."));
        return new UserDetailsImpl(usersEntity);
    }
}
