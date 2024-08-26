package com.angelozero.broker.dataprovider.mongo;

import com.angelozero.broker.dataprovider.mongo.collections.PersonCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<PersonCollection, String> {
    PersonCollection findByCpfAndEmail(String cpf, String email);
}
