package com.angelozero.broker.service.mapper;

import com.angelozero.broker.dataprovider.mongo.collections.MenuCollection;
import com.angelozero.broker.dataprovider.mongo.collections.PersonCollection;
import com.angelozero.broker.service.dto.MenuDTO;
import com.angelozero.broker.service.dto.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    PersonDTO toPerson(PersonCollection personCollection);

    MenuDTO toMenu(MenuCollection menuCollection);

    List<MenuDTO> toMenus(List<MenuCollection> menuCollection);

    @Mapping(target = "menusIds", source = "menus")
    PersonCollection toPersonCollection(PersonDTO person);

    MenuCollection toMenuCollection(MenuDTO menu);


    default List<String> mapMenusToIds(List<MenuDTO> menus) {
        List<String> menusIds = new ArrayList<>();
        return collectMenuIds(menus, menusIds);
    }

    private List<String> collectMenuIds(List<MenuDTO> menus, List<String> menusIds) {
        for (MenuDTO menuDTO : menus) {
            menusIds.add(menuDTO.getId());

            if (menuDTO.getMenus() != null && !menuDTO.getMenus().isEmpty()) {
                collectMenuIds(menuDTO.getMenus(), menusIds);
            }
        }
        return menusIds;
    }
}

