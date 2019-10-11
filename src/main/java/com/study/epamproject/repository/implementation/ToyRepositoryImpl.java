package com.study.epamproject.repository.implementation;

import com.study.epamproject.domain.toy.Manufacturer;
import com.study.epamproject.domain.toy.Toy;
import com.study.epamproject.repository.ToyRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class ToyRepositoryImpl implements ToyRepository {
    private Map<Long, Toy> idToToy = new HashMap<>();

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

    @Override
    public String toString() {
         List<Toy> list = (List) idToToy.values();
         StringBuilder result = new StringBuilder();
         for (Toy t : list) {
             result.append(t.getId()).append(t.getName()).append("\t").append(t.getPrice()).append("\n");
         }
         return result.toString();
    }
}
