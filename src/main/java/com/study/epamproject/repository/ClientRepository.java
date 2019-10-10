package com.study.epamproject.repository;

import com.study.epamproject.domain.users.Client;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client> {
    Optional<Client> findByName(String name);

    Optional<Client> findBySurname(String surname);

    Optional<Client> findByEmail(String email);

    Optional<Client> findByOrder(Long orderId);

}
