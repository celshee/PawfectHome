package com.savePet.PawfectHome.pet;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PetRequestDTOMapper {
    Pet toEntity(PetRequestDTO dto);


    //@Mapping(target = "id", ignore = true)
    //@Mapping(target = "createdAt", ignore = true)
    PetRequestDTO toDto(Pet entity);
}
