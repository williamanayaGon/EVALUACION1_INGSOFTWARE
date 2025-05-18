package com.application.mapper;

import com.application.dto.CreateHolidaysDTO;
import com.application.dto.UpdateHolidayDto;
import com.domain.model.Holiday;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HolidayMapper {
    Holiday toModel(CreateHolidaysDTO createFestivoDTO);
    Holiday toModel(UpdateHolidayDto updateFestivoDto);
    
}
