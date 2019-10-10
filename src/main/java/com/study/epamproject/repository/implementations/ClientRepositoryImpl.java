package com.study.epamproject.repository.implementations;

import com.study.epamproject.domain.users.Client;
import com.study.epamproject.repository.ClientRepository;

import java.util.*;

public class ClientRepositoryImpl<E extends Client> implements ClientRepository<E> {
    Map<Long, Client> idToClient = new HashMap<>();

    @Override
    public Optional<Client> findByName(String name) {
        Optional<Client> client = Optional.empty();

        for (Client c : idToClient.values()) {
            if (Objects.equals(c.getName(), name)) {
                client = Optional.of(c);
            }
        }
        return client;
    }

    @Override
    public Optional<Client> findBySurname(String surname) {
        Optional<Client> client = Optional.empty();

        for (Client c : idToClient.values()) {
            if (Objects.equals(c.getSurname(), surname)) {
                client = Optional.of(c);
            }
        }
        return client;
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        Optional<Client> client = Optional.empty();

        for (Client c : idToClient.values()) {
            if (Objects.equals(c.getEmail(), email)) {
                client = Optional.of(c);
            }
        }
        return client;
    }

    @Override
    public Optional<Client> findByOrder(Long orderId) {
        Optional<Client> client = Optional.empty();

        for (Client c : idToClient.values()) {
            if (Objects.equals(c.getOrdersById().contains(orderId), orderId)) {
                client = Optional.of(c);
            }
        }
        return client;
    }

    @Override
    public Client save(Client user) {
        return idToClient.put(user.getId(), user);

    }

    @Override
    public Optional<E> findById(Long id) {
        return (Optional<E>) Optional.ofNullable(idToClient.get(id));
    }

    @Override
    public List<E> findAll() {
        return (List<E>) idToClient.values();
    }

    @Override
    public void update(E item) {
        idToClient.put(item.getId(), item);
    }

    @Override
    public Optional<E> deleteById(Long id) {
        return (Optional<E>) Optional.ofNullable(idToClient.remove(id));
    }
}
