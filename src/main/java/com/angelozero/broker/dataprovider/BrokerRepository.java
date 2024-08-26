package com.angelozero.broker.dataprovider;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrokerRepository {
    Optional findByCpfAndEmail(String cpf, String email);
}
