package com.angelozero.broker.dataprovider.mongo.gateway;

import com.angelozero.broker.dataprovider.BrokerRepository;
import com.angelozero.broker.dataprovider.mongo.MenuRepository;
import com.angelozero.broker.dataprovider.mongo.PersonRepository;
import com.angelozero.broker.dataprovider.mongo.collections.MenuCollection;
import com.angelozero.broker.dataprovider.mongo.collections.PersonCollection;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.SequencedCollection;

@Service
@AllArgsConstructor
public class MongoGateway implements BrokerRepository {

    private final PersonRepository personRepository;
    private final MenuRepository menuRepository;

    @Override
    public Optional<PersonCollection> findByCpfAndEmail(String cpf, String email) {
        return Optional.ofNullable(personRepository.findByCpfAndEmail(cpf, email));
    }

    public void savePerson(PersonCollection personCollection) {
        personRepository.save(personCollection);
    }

    public void saveMenu(MenuCollection menuCollection) {
        menuRepository.save(menuCollection);
    }

    public Optional<MenuCollection> findByMenuId(String id) {
        return menuRepository.findById(id);
    }

    public SequencedCollection<MenuCollection> findAllMenus(List<String> menusIds) {
        return menuRepository.findByIds(menusIds);
    }
}
