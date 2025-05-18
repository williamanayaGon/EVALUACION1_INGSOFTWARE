package com.application.mapper;

import com.application.dto.CreateCountryDTO;
import com.application.dto.CountryDTO;
import com.application.dto.UpdateCountryDTO;
import com.domain.model.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryDTO toDto(com.domain.model.Country pais);
    CreateCountryDTO toCreateDto(com.domain.model.Country pais);
    UpdateCountryDTO toUpdateDto(com.domain.model.Country pais);
    Country toEntity(com.application.dto.CreateCountryDTO createPaisDTO);
    
}
