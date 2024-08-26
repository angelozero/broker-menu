package com.angelozero.broker.service;

import com.angelozero.broker.dataprovider.mongo.gateway.MongoGateway;
import com.angelozero.broker.service.dto.MenuDTO;
import com.angelozero.broker.service.mapper.ServiceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveMenu {

    private final MongoGateway gateway;
    private final ServiceMapper mapper;

    protected void execute(MenuDTO menu) {

        var menuCollection = gateway.findByMenuId(menu.getId());

        menuCollection.ifPresent(collection -> menu.setId(collection.getId()));

        gateway.saveMenu(mapper.toMenuCollection(menu));
    }
}
