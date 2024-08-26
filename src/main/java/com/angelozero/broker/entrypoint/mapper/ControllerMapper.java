package com.angelozero.broker.entrypoint.mapper;

import com.angelozero.broker.entrypoint.rest.MenuRequest;
import com.angelozero.broker.entrypoint.rest.MenuResponse;
import com.angelozero.broker.entrypoint.rest.PersonRequest;
import com.angelozero.broker.entrypoint.rest.PersonResponse;
import com.angelozero.broker.service.dto.MenuDTO;
import com.angelozero.broker.service.dto.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ControllerMapper {

    ControllerMapper INSTANCE = Mappers.getMapper(ControllerMapper.class);

    PersonResponse toPersonResponse(PersonDTO personDTO);

    MenuResponse toMenuResponse(MenuDTO menuDTO);

    PersonDTO toPersonDTO(PersonRequest personRequest);

    PersonDTO toMenuDTO(MenuRequest menuRequest);
}
