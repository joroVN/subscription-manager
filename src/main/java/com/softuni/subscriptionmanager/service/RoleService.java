package com.softuni.subscriptionmanager.service;

import com.softuni.subscriptionmanager.model.RoleEntity;
import com.softuni.subscriptionmanager.model.enums.RoleEnum;
import com.softuni.subscriptionmanager.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    private void roleInit() {
        List<RoleEntity> roleEntities = Arrays.stream(RoleEnum.values())
                .map(this::map)
                .collect(Collectors.toList());

        this.roleRepository.saveAll(roleEntities);
    }

    private RoleEntity map(RoleEnum role) {
        return new RoleEntity().setRole(role);
    }
}
