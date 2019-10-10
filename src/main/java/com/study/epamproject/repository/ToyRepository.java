package com.study.epamproject.repository;

import com.study.epamproject.domain.toys.Manufacturer;
import com.study.epamproject.domain.toys.Toy;

import java.util.List;
import java.util.Optional;

public interface ToyRepository extends CrudRepository<Toy> {

    List<Toy> findAllByManufacturer(Manufacturer manufacturer);

    Optional<Toy> findByName(String name);

    List<Toy> sortByPrice();
}
