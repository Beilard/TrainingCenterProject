package com.study.epamproject.repository.implementation;

import com.study.epamproject.domain.toy.Manufacturer;
import com.study.epamproject.domain.toy.Toy;
import com.study.epamproject.repository.ToyRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ToyRepositoryImpl implements ToyRepository {
    private List<Toy> toys = new LinkedList<>();

    @Override
    public List<Toy> findAllByManufacturer(Manufacturer manufacturer) {
        List<Toy> list = new LinkedList<>();

        for (Toy t : toys) {
            if (Objects.equals(t.getManufacturer(), manufacturer)) {
                list.add(t);
            }
        }
        return list;
    }

    @Override
    public Optional<Toy> findByName(String name) {
        Optional<Toy> toy = Optional.empty();

        for (Toy t : toys) {
            if (Objects.equals(t.getName(), name)) {
                toy = Optional.of(t);
            }
        }
        return toy;
    }

    @Override
    public List<Toy> sortByPrice() {
        Collections.sort(toys);
        List<Toy> another = toys;
        return toys;
    }

    @Override
    public Toy save(Toy item) {
        toys.add(item);
        return item;
    }

    @Override
    public Optional<Toy> findById(Long id) {
        for (Toy t : toys) {
            if (t.getId().equals(id)) {
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Toy> findAll() {
        return toys;
    }

    @Override
    public void update(Toy item) {
        for (Toy t : toys) {
            if (t.getName().equals(item.getName())) {
                toys.remove(t);
                toys.add(item);
            }
        }
    }

    @Override
    public Optional<Toy> deleteById(Long id) {
        for (Toy t : toys) {
            if (t.getId().equals(id)) {
                return Optional.ofNullable(t);
            }
        }
        return Optional.empty();
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Toy t : toys) {
            result.append(t.getId()).append(" ").append(t.getName()).append("\t").append(t.getPrice()).append("\n");
        }
        return result.toString();
    }

    public List<Toy> getToys() {
        return toys;
    }
}
