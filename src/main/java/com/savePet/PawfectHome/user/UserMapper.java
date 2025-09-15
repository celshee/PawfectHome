package com.savePet.PawfectHome.user;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)           // DB will generate
    @Mapping(target = "role", ignore = true)         // default in entity
    @Mapping(target = "createdAt", ignore = true)
    User toEntity(UserRequestDTO dto);

    UserResponseDTO toDto(User entity);
}

