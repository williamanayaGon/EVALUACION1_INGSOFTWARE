package com.application.mapper;

import com.application.dto.CreateHolidaysDTO;
import com.application.dto.HolidayDateDTO;
import com.domain.model.Holiday;
import com.domain.model.HolidayDate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HolidayDateMapper {
    HolidayDateDTO toDto(HolidayDate festivoConFecha);
    List<HolidayDateDTO> toDtoList(List<HolidayDate> festivosConFecha);
}
