package com.angelozero.broker.service;

import com.angelozero.broker.service.dto.MenuDTO;
import com.angelozero.broker.service.dto.PersonDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveBroker {

    private final SavePerson savePerson;
    private final SaveMenu saveMenu;

    public void execute(PersonDTO personDTO) {
        personDTO.getMenus().forEach(this::saveMenu);
        savePerson.execute(personDTO);
    }

    private void saveMenu(MenuDTO menu) {
        saveMenu.execute(menu);

        if (menu.getMenus() != null) {
            for (MenuDTO submenu : menu.getMenus()) {
                saveMenu(submenu);
            }
        }
    }
}
