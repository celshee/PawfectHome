package com.savePet.PawfectHome.pet;

import org.mapstruct.Mapper;
import java.util.List;


@Mapper(componentModel = "spring")
public interface PetResponseDTOMapper {
    PetResponseDTO toDto(Pet entity);
    List<PetResponseDTO> toDto(List<Pet> pets);
}
