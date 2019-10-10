package com.study.epamproject.repository;

import com.study.epamproject.domain.toys.Manufacturer;
import com.study.epamproject.domain.toys.Toy;

import java.util.List;
import java.util.Optional;

public interface ToyRepository<E extends Toy> extends CrudRepository<E> {

    List<E> findAllByManufacturer(Manufacturer manufacturer);

    Optional<Toy> findByName(String name);

    List<E> sortByPrice();
}
