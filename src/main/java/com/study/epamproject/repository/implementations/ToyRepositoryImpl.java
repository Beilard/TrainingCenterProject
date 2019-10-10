package com.study.epamproject.repository.implementations;

import com.study.epamproject.domain.toys.Manufacturer;
import com.study.epamproject.domain.toys.Toy;
import com.study.epamproject.repository.ToyRepository;

import java.util.*;

public class ToyRepositoryImpl implements ToyRepository {
    Map<Long, Toy> idToToy = new HashMap<>();

    @Override
    public List<Toy> findAllByManufacturer(Manufacturer manufacturer) {
        List<Toy> list = new LinkedList<>();

        for (Toy t : idToToy.values()) {
            if (Objects.equals(t.getManufacturer(), manufacturer)) {
                list.add(t);
            }
        }
        return list;
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
    public List<Toy> sortByPrice() {
        return null;
    }

    @Override
    public Toy save(Toy item) {
        return idToToy.put(item.getId(), item);
    }

    @Override
    public Optional<Toy> findById(Long id) {
        return Optional.ofNullable(idToToy.get(id));
    }

    @Override
    public List<Toy> findAll() {
        return (List<Toy>) idToToy.values();
    }

    @Override
    public void update(Toy item) {
        idToToy.put(item.getId(), item);
    }

    @Override
    public Optional<Toy> deleteById(Long id) {
        return Optional.ofNullable(idToToy.remove(id));
    }
}
