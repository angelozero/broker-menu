package com.angelozero.broker.service;

import com.angelozero.broker.dataprovider.mongo.gateway.MongoGateway;
import com.angelozero.broker.service.dto.MenuDTO;
import com.angelozero.broker.service.dto.PersonDTO;
import com.angelozero.broker.service.mapper.ServiceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class GetBrokerData {

    private final MongoGateway gateway;
    private final ServiceMapper mapper;

    public PersonDTO execute(String cpf, String email) {

        var response = gateway.findByCpfAndEmail(cpf, email).orElse(null);

        if (response != null) {
//            var menus = new ArrayList<>(gateway.findAllMenus(response.getMenusIds())).stream().map(mapper::toMenu).collect(Collectors.toList());
            var menus = mapper.toMenus(new ArrayList<>(gateway.findAllMenus(response.getMenusIds())));
            var hierarchyMenus = buildMenuHierarchy(menus);
            var personDto = mapper.toPerson(response);
            personDto.setMenus(hierarchyMenus);
            return personDto;
        }
        return null;
    }

    private static List<MenuDTO> buildMenuHierarchy(List<MenuDTO> menuList) {
        Map<String, MenuDTO> menuMap = new HashMap<>();

        List<MenuDTO> topMenus = new ArrayList<>();

        for (MenuDTO menu : menuList) {
            menuMap.put(menu.getId(), menu);
        }

        for (MenuDTO menu : menuList) {
            if (menu.getHighLevel() != null && menuMap.containsKey(menu.getHighLevel())) {
                MenuDTO parent = menuMap.get(menu.getHighLevel());
                if (parent.getMenus() == null) {
                    parent.setMenus(new ArrayList<>());
                }
                parent.getMenus().add(menu);
            } else {
                topMenus.add(menu);
            }
        }

        return topMenus;
    }
}
