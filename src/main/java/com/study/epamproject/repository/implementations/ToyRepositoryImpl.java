package com.study.epamproject.repository.implementations;

import com.study.epamproject.domain.toys.Manufacturer;
import com.study.epamproject.domain.toys.Toy;
import com.study.epamproject.repository.ToyRepository;

import java.util.*;

public class ToyRepositoryImpl<E extends Toy> implements ToyRepository<E> {
    Map<Long, Toy> idToToy = new HashMap<>();

    @Override
    public List<E> findAllByManufacturer(Manufacturer manufacturer) {
        List<Toy> list = new LinkedList<>();

        for (Toy t : idToToy.values()) {
            if (Objects.equals(t.getManufacturer(), manufacturer)) {
                list.add(t);
            }
        }
        return (List<E>) list;
    }

    @Override
    public Optional<Toy> findByName(String name) {
        Optional<Toy> toy = Optional.empty();

        for (Toy t : idToToy.values()) {
            if (Objects.equals(t.getName(), name)) {
                toy = Optional.of(t);
            }
        }
        return toy;
    }

    @Override
    public List<E> sortByPrice() {
        return null;
    }

    @Override
    public Toy save(Toy item) {
        return idToToy.put(item.getId(), item);
    }

    @Override
    public Optional<E> findById(Long id) {
        return (Optional<E>) Optional.ofNullable(idToToy.get(id));
    }

    @Override
    public List<E> findAll() {
        return (List<E>) idToToy.values();
    }

    @Override
    public void update(E item) {
        idToToy.put(item.getId(), item);
    }

    @Override
    public Optional<E> deleteById(Long id) {
        return (Optional<E>) Optional.ofNullable(idToToy.remove(id));
    }
}
