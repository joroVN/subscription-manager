package com.softuni.subscriptionmanager.service;

import com.softuni.subscriptionmanager.model.RoleEntity;
import com.softuni.subscriptionmanager.model.UserEntity;
import com.softuni.subscriptionmanager.model.user.AppUserDetails;
import com.softuni.subscriptionmanager.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AppUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public AppUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(email)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found!"));
    }

    private UserDetails map(UserEntity userEntity) {
        return new AppUserDetails(
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getUserRoles()
                        .stream()
                        .map(this::map)
                        .toList()
        );
    }

    private GrantedAuthority map(RoleEntity roleEntity) {
        return new SimpleGrantedAuthority("ROLE_" + roleEntity.getRole().name());
    }
}
