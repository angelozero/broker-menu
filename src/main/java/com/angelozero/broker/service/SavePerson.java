package com.angelozero.broker.service;

import com.angelozero.broker.dataprovider.mongo.gateway.MongoGateway;
import com.angelozero.broker.service.dto.PersonDTO;
import com.angelozero.broker.service.mapper.ServiceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SavePerson {

    private final MongoGateway gateway;
    private final ServiceMapper mapper;

    protected void execute(PersonDTO person) {
        gateway.savePerson(mapper.toPersonCollection(person));
    }
}
