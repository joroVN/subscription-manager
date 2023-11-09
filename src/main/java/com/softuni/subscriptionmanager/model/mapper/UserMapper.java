package com.softuni.subscriptionmanager.model.mapper;

import com.softuni.subscriptionmanager.model.UserEntity;
import com.softuni.subscriptionmanager.model.dto.UserRegisterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    UserEntity userDtoToUserEntity(UserRegisterDTO userRegisterDTO);
}
